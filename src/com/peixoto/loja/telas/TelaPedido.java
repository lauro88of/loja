package com.peixoto.loja.telas;

import com.peixoto.loja.domain.cadastro.Cliente;
import com.peixoto.loja.domain.estoque.Produto;
import com.peixoto.loja.domain.pedido.ItemPedido;
import com.peixoto.loja.domain.pedido.Pedido;
import com.peixoto.loja.repositorio.ClienteRepositorio;
import com.peixoto.loja.repositorio.PedidoRepositorio;
import com.peixoto.loja.repositorio.ProdutoRepositorio;
import com.peixoto.loja.repositorio.Repositorio;
import com.peixoto.loja.servicos.PedidoService;
import com.peixoto.loja.servicos.ProdutoService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class TelaPedido implements Tela {

    Scanner entrada ;
    final private ProdutoRepositorio produtoRepositorio;
    final private Repositorio<Cliente, String> clienteRepositorio;
    final private PedidoRepositorio pedidoRepositorio ;
    final private ProdutoService produtoService ;
    final private PedidoService pedidoService ;

    public TelaPedido(Scanner entrada) {
        this.entrada = entrada;
        produtoRepositorio = new ProdutoRepositorio();
        clienteRepositorio = new ClienteRepositorio();
        produtoService = new ProdutoService();
        pedidoService = new PedidoService();
        pedidoRepositorio = new PedidoRepositorio();
    }

    @Override
    public void abrirTela() {
        System.out.println("Tela de Pedidos, amigo");
        int opcao;
        do {
            System.out.println("0 - Sair do sistema de Pedidos");
            System.out.println("1 - Efetivar um Pedido");
            System.out.println("2 - Mostrar Pedidos por Data");
            System.out.println("3 - Mostrar Todos os Pedidos");
            opcao = Integer.parseInt(this.entrada.nextLine());
            if(opcao == 1) {
                criarPedido();
            }
            else if(opcao == 2) {
                int opcaoConsultaData;
                do {
                    System.out.println("0 - Sair da consulta de pedido por data");
                    System.out.println("1 - Consultar data exata");
                    System.out.println("2 - Consultar pedidos antes de:");
                    System.out.println("3 - Consultar pedidos depois de");
                    opcaoConsultaData = Integer.parseInt(this.entrada.nextLine());

                    if(opcaoConsultaData != 0){
                        System.out.println("Informe a data no formato dd/MM/yyyy");
                        String stringDataConsulta = this.entrada.nextLine();
                        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                        LocalDate dataConsulta = LocalDate.parse(stringDataConsulta,formatter);

                        switch (opcaoConsultaData){
                            case 1:
                                System.out.println(pedidoRepositorio.buscarPedidosNaData(dataConsulta));
                                break;
                            case 2:
                                System.out.println(pedidoRepositorio.buscarPedidosAntesDe(dataConsulta));
                                break;
                            case 3:
                                System.out.println(pedidoRepositorio.buscarPedidosDepoisDe(dataConsulta));
                                break;
                            default:
                                break;
                        }

                    }



                }while (opcaoConsultaData != 0);

            }else if (opcao == 3) {
                listarTodosProdutos();
            }

        } while (opcao != 0);
    }

    private void listarTodosProdutos() {
        List<Pedido> pedidosSalvos = pedidoRepositorio.buscarTodos();

        if(pedidosSalvos.isEmpty()){
            System.out.println("Não existe pedido na base de dados");
        }else{
            for(Pedido pedido : pedidosSalvos){
                System.out.println(pedido);
            }
        }
    }

    private void criarPedido() {
        System.out.println("Informe o cliente para o pedido: ");
        String cpf = this.entrada.nextLine();
        Cliente cliente = clienteRepositorio.buscarPorCodigo(cpf);
        //criar pedido e código do pedido, informar em tela

        if(cliente != null) {
            produtoService.mostrarProdutos(produtoRepositorio.buscarProdutosComEstoque());
            Pedido pedido = new Pedido();
            pedido.setDataPedido(LocalDate.now());
            pedido.setCliente(cliente);

            int opcaoPedido;

            do {
                Produto produto;
                do {
                    produto = selecionarProdutoComEstoque();
                } while (produto == null || !produtoService.temEstoque(produto));

                incluirItemNoPedido(pedido, produto);
                System.out.println("Digite 0 para sair , 1 para adicionar novo item e 2 para salvar o pedido: ");
                opcaoPedido = Integer.parseInt(this.entrada.nextLine());

                if(opcaoPedido == 2){
                    pedidoRepositorio.salvar(pedido);
                }

            }while (opcaoPedido == 1);

        } else {
            System.out.println("Cliente não existe em nosso cadastro!");
        }
    }

    private Produto selecionarProdutoComEstoque() {
        Produto produto;
        System.out.println("Informe o nome do produto: ");
        String nomeProduto = this.entrada.nextLine();
        produto = produtoRepositorio.buscarProdutoPorNome(nomeProduto);
        if (produto == null) {
            System.out.println("Produto inexistente");
        }else if(!produtoService.temEstoque(produto)){
            System.out.println("Produto sem estoque favor informar outro produto");
        }
        return produto;
    }

    private void incluirItemNoPedido(Pedido pedido, Produto produto) {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setProduto(produto);
        System.out.println("Informe a quantidade ");
        itemPedido.setQuantidade(Integer.parseInt(this.entrada.nextLine()));
        pedidoService.addItemPedido(pedido,itemPedido);
    }
}

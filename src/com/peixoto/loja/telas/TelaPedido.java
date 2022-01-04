package com.peixoto.loja.telas;

import com.peixoto.loja.domain.cadastro.Cliente;
import com.peixoto.loja.domain.estoque.Produto;
import com.peixoto.loja.domain.pedido.Pedido;
import com.peixoto.loja.repositorio.ClienteRepositorio;
import com.peixoto.loja.repositorio.ProdutoRepositorio;
import com.peixoto.loja.repositorio.Repositorio;

import java.util.List;
import java.util.Scanner;

public class TelaPedido implements Tela {

    Scanner entrada ;
    private Repositorio<Produto, Long> produtoRepositorio;
    private Repositorio<Cliente, String> clienteRepositorio;

    public TelaPedido(Scanner entrada) {
        this.entrada = entrada;
        produtoRepositorio = new ProdutoRepositorio();
        clienteRepositorio = new ClienteRepositorio();
    }

    @Override
    public void abrirTela() {
        System.out.println("Tela de Pedidos, amigo");
        int opcao = 0;
        do {
            System.out.println("0 - Sair do sistema de Pedidos");
            System.out.println("1 - Efetivar um Pedido");
            System.out.println("2 - Mostrar Pedidos por cliente");
            System.out.println("3 - Mostrar Todos os Pedidos");
            opcao = Integer.parseInt(this.entrada.nextLine());
            if(opcao == 1) {
                System.out.println("Informe o cliente para o pedido: ");
                String cpf = this.entrada.nextLine();
                Cliente cliente = clienteRepositorio.buscarPorCodigo(cpf);

                if(cliente != null) {
                    //criar pedido e código do pedido, informar em tela
                    Pedido pedido = new Pedido();
                    System.out.println("Informe o nome do produto: ");

                    //Buscar produtos pelo nome...
                    //Listar produtos cod e nome e estoque...
                    //Abrir seleção pelo cod do produto, usuário informa o código do produto...
                    //usuario informa a quantidade do item
                    //verifica se tem estoque  quantidadeEstoque - quantidadeInformada > 0
                    // adiciona o produto na lista de itens no pedido

                    produtoRepositorio.buscarPorCodigo(22L);

                } else {
                    System.out.println("Cliente não existe em nosso cadastro!");
                }
            }
            if(opcao == 2) {


            }
            if (opcao == 3) {

            }

        } while (opcao != 0);
    }
}

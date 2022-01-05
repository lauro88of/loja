package com.peixoto.loja.telas;

import com.peixoto.loja.domain.estoque.Produto;
import com.peixoto.loja.repositorio.ProdutoRepositorio;
import com.peixoto.loja.repositorio.Repositorio;

import java.util.List;
import java.util.Scanner;

public class TelaEstoque  implements Tela {

    final private Scanner entradaEstoque;
    private Repositorio<Produto, Long> produtoRepositorio;
    public TelaEstoque(Scanner entradaEstoque) {
        this.entradaEstoque = entradaEstoque;
        this.produtoRepositorio = new ProdutoRepositorio();
    }
    @Override
    public void abrirTela() {

        System.out.println("Bem vindo ao sistema de Estoque amigo Adm");
        int opcao = 0;
        do {
            System.out.println("0 - Sair do sistema de estoque");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Produtos");
            System.out.println("3 - Estoque disponível do Produto");
            opcao = Integer.parseInt(this.entradaEstoque.nextLine());
            if(opcao == 1) {
                Produto produto = entrarProdutoNaTela();
                this.produtoRepositorio.salvar(produto);
            }
            if(opcao == 2) {
                List<Produto> produtos = this.produtoRepositorio.buscarTodos();
                mostrarProdutos(produtos);
            }
            if (opcao == 3) {
                System.out.println("Informe o código do produto: ");
                Long codigoProdutoASerPesquisado = Long.parseLong(this.entradaEstoque.nextLine());
                Produto produtoDoEncontradoNaBusca = this.produtoRepositorio.buscarPorCodigo(codigoProdutoASerPesquisado);
                System.out.println("O Estoque é: ");
                System.out.println(produtoDoEncontradoNaBusca.getEstoque());
            }

        } while (opcao != 0);

    }

    private void mostrarProdutos(List<Produto> produtos) {
        for(Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + " | Valor: " + produto.getValor() + " | Quantidade estoque: " + produto.getEstoque() );
        }
    }

    private Produto entrarProdutoNaTela() {
        Produto produto = new Produto();
        System.out.println("Informe o Código: ");
        produto.setCodigo(Long.parseLong(this.entradaEstoque.nextLine()));
        System.out.println("Informe o Nome: ");
        produto.setNome(this.entradaEstoque.nextLine());
        System.out.println("Informe a Descrição: ");
        produto.setDescricao(this.entradaEstoque.nextLine());
        System.out.println("Informe o Valor: ");
        produto.setValor(Double.parseDouble(this.entradaEstoque.nextLine()));
        System.out.println("Informe o Estoque: ");
        produto.setEstoque(Integer.parseInt(this.entradaEstoque.nextLine()));
        return produto;
    }
}

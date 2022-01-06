package com.peixoto.loja.servicos;

import com.peixoto.loja.domain.estoque.Produto;

import java.util.List;

public class ProdutoService {

    public boolean temEstoque(Produto produto){
        return produto.getEstoque() != null && produto.getEstoque() > 0;
    }

    public void mostrarProdutos(List<Produto> produtos) {
        for(Produto produto : produtos) {
            System.out.println("Nome: " + produto.getNome() + " | Valor: " + produto.getValor() + " | Quantidade estoque: " + produto.getEstoque() );
        }
    }
}

package com.peixoto.loja.repositorio;

import com.peixoto.loja.domain.cadastro.Cliente;
import com.peixoto.loja.domain.estoque.Produto;

import java.util.ArrayList;
import java.util.List;

public class ProdutoRepositorio implements Repositorio<Produto, Long> {

    private static List<Produto> listaProdutos = new ArrayList<>();

    public ProdutoRepositorio() {
        if(listaProdutos.isEmpty()) {
            listaProdutos.add(new Produto(1L,"SH SEDA HIDRATACAO N-IO", "SHAMPOO DE HIDRATACAO",50.50,10 ));
            listaProdutos.add(new Produto(2L,"CELULAR", "CELULAR",9.0000,100 ));
            listaProdutos.add(new Produto(3L,"CARREGADOR IPHONE", "CARREGADOR",1500.0,10 ));
            listaProdutos.add(new Produto(4L,"CARREGADOR LG", "CARREGADOR",1500.0,10 ));
            listaProdutos.add(new Produto(5L,"TV", "TV",1500.0,0 ));
        }
    }

    public void salvar(Produto produto) {

        listaProdutos.add(produto);
    }

    public List<Produto> buscarTodos() {
        return listaProdutos;
    }

    public Produto buscarPorCodigo(Long codigo) {
        Produto produtoDoEncontrado = null;
        for(Produto produtoNaLista : listaProdutos) {
            if(produtoNaLista.getCodigo().equals(codigo)) {
                produtoDoEncontrado = produtoNaLista;
            }
        }
        return produtoDoEncontrado;
    }

    public List<Produto> buscarProdutosComEstoque(){
        List<Produto> produtosComEstoque = new ArrayList<>();
        for(Produto produtoNaLista : listaProdutos) {
            if(produtoNaLista.getEstoque()>0) {
                produtosComEstoque.add(produtoNaLista);
            }
        }
        return produtosComEstoque;
    }

    public Produto buscarProdutoPorNome(String nome){
        Produto produtoDoEncontrado = null;
        for(Produto produtoNaLista : listaProdutos) {
            if(produtoNaLista.getNome().equalsIgnoreCase(nome)) {
                produtoDoEncontrado = produtoNaLista;
            }
        }
        return produtoDoEncontrado;
    }

}

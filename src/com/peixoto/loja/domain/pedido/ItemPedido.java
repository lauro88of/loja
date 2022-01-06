package com.peixoto.loja.domain.pedido;

import com.peixoto.loja.domain.estoque.Produto;

public class ItemPedido {
    private Produto produto;
    private Integer quantidade;
    private Double preco;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }


    @Override
    public String toString() {
        return "{"+
                "\"produto\":" + (produto == null ? "null" : produto) + ", " +
                "\"quantidade\":" + (quantidade == null ? "null" : "\"" + quantidade + "\"") + ", " +
                "\"preco\":" + (preco == null ? "null" : "\"" + preco + "\"") +
                "}";
    }
}

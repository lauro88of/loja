package com.peixoto.loja.domain.estoque;

public class Produto {

    private Long codigo;
    private String nome;
    private String descricao;
    private String imagem;
    private Double valor;
    private Integer estoque;

    public Produto() {
    }

    public Produto(Long codigo, String nome, String descricao, Double valor, Integer estoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.estoque = estoque;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Integer getEstoque() {
        return estoque;
    }

    public void setEstoque(Integer estoque) {
        this.estoque = estoque;
    }


    @Override
    public String toString() {
        return "{" +
                "\"codigo\":" + (codigo == null ? "null" : "\"" + codigo + "\"") + ", " +
                "\"nome\":" + (nome == null ? "null" : "\"" + nome + "\"") +
                "}";
    }
}

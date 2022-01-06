package com.peixoto.loja.domain.cadastro;

import java.time.LocalDate;
import java.util.Objects;

public class Cliente {
    private Long codigo;
    private String cpf;
    private String nome;
    private String endereco;
    private LocalDate dataExpiracaoCadastro;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String endereco) {
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataExpiracaoCadastro() {
        return dataExpiracaoCadastro;
    }

    public void setDataExpiracaoCadastro(LocalDate dataExpiracaoCadastro) {
        this.dataExpiracaoCadastro = dataExpiracaoCadastro;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return cpf.equals(cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cpf);
    }
}

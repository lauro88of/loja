package com.peixoto.loja.repositorio;

import com.peixoto.loja.domain.cadastro.Cliente;

import java.util.ArrayList;
import java.util.List;

public class ClienteRepositorio implements Repositorio<Cliente, String>{

    private static List<Cliente> listaCliente = new ArrayList<>();


    public ClienteRepositorio() {
        if(listaCliente.isEmpty()) {
            listaCliente.add(new Cliente("12345678911", "Lauro O Freitas", "R: Wilson"));
            listaCliente.add(new Cliente("12345678912", "Milton", "R: Pedro"));
            listaCliente.add(new Cliente("12345678913", "Caroline", "R: Afonso"));
        }
    }

    @Override
    public void salvar(Cliente cliente) {
        validaDadosCliente(cliente);
        listaCliente.add(cliente);
    }

    private void validaDadosCliente(Cliente cliente) {
        if(cliente.getCpf() == null){
            System.out.println("cliente não foi salvo");
        }
        if(cliente.getNome() == null){
            System.out.println("cliente não foi salvo");
        }
    }

    @Override
    public List<Cliente> buscarTodos() {
        return listaCliente;
    }


    public Cliente buscarClientePorCpf(String cpf) {
        Cliente clienteEncontrado = null;
        for(Cliente clienteNaLista : listaCliente) {
            if(clienteNaLista.getCpf().equals(cpf)) {
                clienteEncontrado = clienteNaLista;
            }
        }
        return clienteEncontrado;
    }

    @Override
    public Cliente buscarPorCodigo(String codigo) {
        return buscarClientePorCpf(codigo);
    }
}

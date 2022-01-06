package com.peixoto.loja.servicos;

import com.peixoto.loja.domain.cadastro.Cliente;

import java.time.LocalDate;

public class ClienteServico {

    public boolean clienteEstaExpirado(Cliente cliente){
        if(cliente.getDataExpiracaoCadastro() == null){
            cliente.setDataExpiracaoCadastro(calcularDataExpiracaoCliente(cliente));
        }
        return LocalDate.now().isAfter(cliente.getDataExpiracaoCadastro());
    }

    public LocalDate calcularDataExpiracaoCliente(Cliente cliente){
        if(cliente != null){
            return LocalDate.now().minusDays(10).plusDays(cliente.getNome().length());
        }else{
            return LocalDate.now();
        }
    }
}

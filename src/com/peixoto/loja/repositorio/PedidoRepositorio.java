package com.peixoto.loja.repositorio;

import com.peixoto.loja.domain.cadastro.Cliente;
import com.peixoto.loja.domain.pedido.Pedido;

import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorio implements Repositorio<Pedido, Long>{

    List<Pedido> pedidos = new ArrayList<>();

    public void salvar(Pedido pedido) {
        pedidos.add(pedido);
    }

    public List<Pedido> buscarTodos() {
        return pedidos;
    }

    @Override
    public Pedido buscarPorCodigo(Long codigo) {
        return null;
    }
}

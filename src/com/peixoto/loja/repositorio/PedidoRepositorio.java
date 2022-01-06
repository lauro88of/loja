package com.peixoto.loja.repositorio;

import com.peixoto.loja.domain.pedido.Pedido;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PedidoRepositorio implements Repositorio<Pedido, Long>{

    static final List<Pedido> pedidos = new ArrayList<>();

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

    public List<Pedido> buscarPedidosNaData(LocalDate dataConsulta) {
        List<Pedido> resultado = new ArrayList<>();
        for(Pedido pedido:pedidos){
            if(dataConsulta.isEqual(pedido.getDataPedido())){
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public List<Pedido> buscarPedidosAntesDe(LocalDate dataConsulta) {
        List<Pedido> resultado = new ArrayList<>();
        for(Pedido pedido:pedidos){
            if(dataConsulta.isAfter(pedido.getDataPedido())){
                resultado.add(pedido);
            }
        }
        return resultado;
    }

    public List<Pedido> buscarPedidosDepoisDe(LocalDate dataConsulta) {
        List<Pedido> resultado = new ArrayList<>();
        for(Pedido pedido:pedidos){
            if(dataConsulta.isBefore(pedido.getDataPedido())){
                resultado.add(pedido);
            }
        }
        return resultado;
    }
}

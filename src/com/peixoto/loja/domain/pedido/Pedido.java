package com.peixoto.loja.domain.pedido;

import com.peixoto.loja.domain.cadastro.Cliente;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class Pedido {
    private Long codigo;
    private List<ItemPedido> listaItemPedido;
    private LocalDate dataPedido;
    private Cliente cliente;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public List<ItemPedido> getListaItemPedido() {
        return listaItemPedido;
    }

    public void setListaItemPedido(List<ItemPedido> listaItemPedido) {
        this.listaItemPedido = listaItemPedido;
    }

    public LocalDate getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDate dataPedido) {
        this.dataPedido = dataPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return "{" +
                "\"codigo\":" + (codigo == null ? "null" : "\"" + codigo + "\"") + ", " +
                "\"listaItemPedido\":" + (listaItemPedido == null ? "null" : listaItemPedido) + ", " +
                "\"dataPedido\":" + (dataPedido == null ? "null" : dataPedido) + ", " +
                "\"cliente\":" + (cliente == null ? "null" : cliente) +
                "}";
    }
}

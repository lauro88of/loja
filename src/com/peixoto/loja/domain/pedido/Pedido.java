package com.peixoto.loja.domain.pedido;

import com.peixoto.loja.domain.cadastro.Cliente;

import java.util.Date;
import java.util.List;

public class Pedido {
    private Long codigo;
    private List<ItemPedido> listaItemPedido;
    private Date dataPedido;
    private Cliente cliente;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }
}

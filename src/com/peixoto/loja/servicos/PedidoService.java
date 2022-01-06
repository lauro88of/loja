package com.peixoto.loja.servicos;

import com.peixoto.loja.domain.pedido.ItemPedido;
import com.peixoto.loja.domain.pedido.Pedido;

import java.util.ArrayList;

public class PedidoService {

    public void addItemPedido(Pedido pedido, ItemPedido itemPedido){
        if(pedido.getListaItemPedido() == null){
            pedido.setListaItemPedido(new ArrayList<>());
        }

        itemPedido.getProduto().setEstoque(itemPedido.getProduto().getEstoque() - itemPedido.getQuantidade());

        pedido.getListaItemPedido().add(itemPedido);
    }
}

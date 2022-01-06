package com.peixoto.loja.telas;

import java.util.Scanner;

public class TelaPrincipal implements Tela {


    @Override
    public void abrirTela() {
        Tela tela = null;
        int opcao = 0;
        Scanner entrada = new Scanner(System.in);
        System.out.println("***************Bem Vindo Amigo Administrador da Loja****************");
        do {
            System.out.println("0 - Fechar Sistema");
            System.out.println("1 - Abrir Tela do Estoque");
            System.out.println("2 - Gerenciador de Pedidos");
            System.out.println("3 - Gerenciador de Clientes");
            opcao = Integer.parseInt(entrada.nextLine());
            if(opcao == 1) {
                tela = new TelaEstoque(entrada);
                tela.abrirTela();
            }
            if(opcao == 2) {
                tela = new TelaPedido(entrada);
                tela.abrirTela();
            }if(opcao == 3) {
                tela = new TelaCliente(entrada);
                tela.abrirTela();
            }
        }while (opcao != 0);
        System.out.println("Fechou a Tela");
    }
}

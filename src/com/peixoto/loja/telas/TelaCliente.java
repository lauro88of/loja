package com.peixoto.loja.telas;

import com.peixoto.loja.domain.cadastro.Cliente;
import com.peixoto.loja.repositorio.ClienteRepositorio;
import com.peixoto.loja.servicos.ClienteServico;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

public class TelaCliente implements Tela{
    final private Scanner entradaCliente;
    final private ClienteRepositorio clienteRepositorio;
    final private ClienteServico clienteServico;

    public TelaCliente(Scanner entradaCliente) {
        this.entradaCliente = entradaCliente;
        this.clienteRepositorio = new ClienteRepositorio();
        this.clienteServico = new ClienteServico();
    }

    @Override
    public void abrirTela() {

        System.out.println("Bem vindo ao sistema de Estoque amigo Adm");
        int opcao = 0;
        do {
            System.out.println("0 - Sair do sistema de estoque");
            System.out.println("1 - Cadastrar Cliente");
            System.out.println("2 - Listar Cliente");
            opcao = Integer.parseInt(this.entradaCliente.nextLine());
            if(opcao == 1) {
                Cliente produto = entrarClienteNaTela();
                this.clienteRepositorio.salvar(produto);
            }
            if(opcao == 2) {
                List<Cliente> produtos = this.clienteRepositorio.buscarTodos();
                mostrarClientes(produtos);
            }
            

        } while (opcao != 0);
    }

    private void mostrarClientes(List<Cliente> clientes) {

        for(Cliente cliente:clientes){
            System.out.print("Nome: "+ cliente.getNome());
            if(clienteServico.clienteEstaExpirado(cliente)){
                System.out.println("** Cadastro expirado ** " + cliente.getDataExpiracaoCadastro());
            }else{
                System.out.println("** Qtd dias expiração cadastro ** " + ChronoUnit.DAYS.between(LocalDate.now(),cliente.getDataExpiracaoCadastro()));
            }
        }
    }

    private Cliente entrarClienteNaTela() {
        Cliente cliente = new Cliente();
        System.out.println("Informe o Código: ");
        cliente.setCodigo(Long.parseLong(this.entradaCliente.nextLine()));
        System.out.println("Informe o Nome: ");
        cliente.setNome(this.entradaCliente.nextLine());
        cliente.setDataExpiracaoCadastro(clienteServico.calcularDataExpiracaoCliente(cliente));
        return cliente;
    }
}

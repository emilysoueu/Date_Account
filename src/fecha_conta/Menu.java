/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fecha_conta;

import java.util.Scanner;

/**
 *
 * @author emilysoueu
 */
public class Menu extends Restaurante {  // usar o mesmo construtor de Restaurante

    Menu(int numGarcom, int NumItens, int numMesas) {
        super(numGarcom, NumItens, numMesas);

    }

    Scanner in = new Scanner(System.in);

    public void menu() {
        int menu, user, manager;
        int numMesa;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............[1]Administração.....................................");
            System.out.println(".............[2]Usuário...........................................");
            System.out.println(".............[0]Sair..............................................");
            user = in.nextInt();

            switch (user) {
                // Interface Gerente
                case 1: {

                    menuManager();

                }// fim case 1
                break;

                // Interface Cliente
                case 2: {

                    menuClient();

                }//fim case 2
                break;

            }// fim switchc user
        } while (user != 0);
    }

    void menuManager() {
        int manager = 0;
        int numMesa;
        do {
            System.out.println(".............[1]Descrição Mesa.....................................");
            System.out.println(".............[2]Descrição Balcão.....................................");
            System.out.println(".............[3]Descrição Restaurante.....................................");
            System.out.println(".............[0]Voltar.....................................");
            manager = in.nextInt();

            switch (manager) {
                // descrição de uma mesa especifica
                case 1: {

                    System.out.println(".............Informe O Numero da mesa:............................");
                    numMesa = in.nextInt();
                    this.listaMesa.get(numMesa).printMesa();

                }
                break;
                //descrição do balcão
                case 2: {
                    this.getBar(); // não sei o que essa função faz exatamente
                }
                break;
                // descrição de todas as mesas e do balcão
                case 3: {
                    int i = 0;
                    System.out.println("Descrição de Todas as Mesas: ");
                    for (Mesa aux : listaMesa) {
                        i++;
                        System.out.println("Mesa " + i + " : ");
                        aux.printMesa();
                    }
                    System.out.println("Descrição do Balcão: ");
                    this.getBar();
                }
                break;

            }
        } while (manager != 0);

    }

    void menuClient() {
        int menu;
        do {
            System.out.println(".............Bem Vindo ao Restaurante Poneis Dourados.............");
            System.out.println(".............Atendimento.........................................:");
            System.out.println(".............[1]Mesa.....................................");
            System.out.println(".............[2]Balcão...........................................");
            System.out.println(".............[0]Voltar...........................................");
            menu = in.nextInt();
            switch (menu) {

                //Atendimento Mesa
                case 1: {

                    menuMesa();

                }
                break;
                // atendimmento em balcao
                case 2: {

                    menuBalcao();

                }
                break;

            }
        } while (menu != 0);

    }

    void menuMesa() {
        int qtdCliente = 0;
        int garcom;
        int numMesa;

        int numItem; // recebe pedidos do cliente
        int qtdItem;
        double valorUni;

        System.out.println("Informe a quantidade de Clientes na mesa:");
        qtdCliente = in.nextInt();
        System.out.println("Informe o numero do garçom para atendê - lo:");
        garcom = in.nextInt();
        System.out.println("Informe o numero da mesa:");
        numMesa = in.nextInt();

        // Mesa xMesa = new Mesa(qtdCliente,0,1,qtdCliente,garcom,numMesa,true);
        Mesa xMesa = this.abrirContaMesa(qtdCliente, garcom, numMesa);
        xMesa.setGarcom(garcom);
        xMesa.setQtdClientes(qtdCliente);

        for (Clientes aux : xMesa.tempClientes) {

            do {
                System.out.println("Numero do item(0 para encerar pedido) : ");
                numItem = in.nextInt();

                if (numItem == 0) {
                    break;
                }

                System.out.println("Quantidade do item: ");
                qtdItem = in.nextInt();

                System.out.println("Qual o valor unitário do item: ");
                valorUni = in.nextDouble();

                aux.addPedido(numItem, qtdItem, valorUni);

            } while (numItem != 0);

        }

        System.out.println("### MESA ATENDIDA ###");
        xMesa.printMesa();

    }

    void menuBalcao() {
        int garcom;
        int pessoa;
        Balcao bar = null;
        do {
            int numItem; // recebe pedidos do cliente
            int qtdItem;
            double valorUni;

            System.out.println("Informe o numero do garçom para atendê-lo:");
            garcom = in.nextInt();
            this.abrirContaBalcao(garcom); // informar numero do garçom

            Clientes xCliente = this.abrirContaBalcao(garcom);
            do {
                System.out.println("Numero do item(0 para encerar pedido) : ");
                numItem = in.nextInt();

                if (numItem == 0) {
                    break;
                }

                System.out.println("Quantidade do item: ");
                qtdItem = in.nextInt();

                System.out.println("Qual o valor unitário do item: ");
                valorUni = in.nextDouble();

                xCliente.addPedido(numItem, qtdItem, valorUni);

            } while (numItem != 0);

            System.out.println("### CLIENTE ATENDIDO ###");
            xCliente.printCliente();
            xCliente.printPedido();

            System.out.println("............Editar Pedido......................");
            System.out.println("............[1]SIM.........................");
            System.out.println("............[0]NÃO.........................");
            int edit = in.nextInt();
            switch (edit) {

                case 1: {
                    System.out.println("\n................Informe o Cliente que deseja alterar pedido:");
                    pessoa = in.nextInt();
                    int pedido, del;
                    System.out.println("............[1]Adicionar Pedido ...................");
                    System.out.println("............[2]Deletar Item Pedido.................");
                    pedido = in.nextInt();
                    switch (pedido) {

                        case 1: {

                        }
                        break;
                        case 2: {

                            System.out.println("\n..............Informe o numero do Item:......");
                            del = in.nextInt();
                            bar.clienteDelItem(pessoa, del);

                        }
                        break;
                    }

                    System.out.println("### CLIENTE ATENDIDO - PEDIDO COM ALTERAÇÃO ###");
                    xCliente.printCliente();
                    xCliente.printPedido();
                }
                break;
                case 0:
                    break;

            }
        } while (garcom != 0);

    }

}

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
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............[1]Descrição.........................................");
            System.out.println(".............[2]Relatorios........................................");
            System.out.println(".............[0]Voltar............................................");
            manager = in.nextInt();

            switch (manager) {
                // descrição de uma mesa especifica
                case 1: {
                    menuDescricao();
                }
                break;
                //descrição do balcão
                case 2: {
                    menuRelatorio();
                }
                break;
            }
        } while (manager != 0);
    }

    void menuDescricao() {
        int manager = 0;
        int numMesa;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............[1]Descrição Mesa....................................");
            System.out.println(".............[2]Descrição Balcão..................................");
            System.out.println(".............[3]Descrição Restaurante.............................");
            System.out.println(".............[0]Voltar............................................");
            manager = in.nextInt();

            switch (manager) {
                // descrição de uma mesa especifica
                case 1: {
                    System.out.println(".............Informe O Numero da mesa:....................");
                    numMesa = in.nextInt();
                    Mesa aux = this.getMesa(numMesa);
                    aux.print();
                }
                break;
                //descrição do balcão
                case 2: {
                    //this.getBar(); // não sei o que essa função faz exatamente
                    this.bar.print();
                }
                break;
                // descrição de todas as mesas e do balcão
                case 3: {
                    this.descricao();
                }
                break;
            }
        } while (manager != 0);
    }

    void menuRelatorio() {
        int manager = 0;
        //int numMesa;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............[1]Contas em Aberto..................................");
            System.out.println(".............[2]Total Diário......................................");
            System.out.println(".............[3]Garcom............................................");
            System.out.println(".............[0]Voltar............................................");
            manager = in.nextInt();

            switch (manager) {
                // relatorio de contas em aberto
                case 1: {
                    this.relatorioAberto();
                }
                break;
                // relatorio do total arrecardado no dia
                case 2: {
                    this.relatorioFinal();
                }
                break;
                // relatorio do total a cada garcom
                case 3: {
                    this.relatorioGarcom();
                }
            }
        } while (manager != 0);
    }

    void menuClient() {
        int menu;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............Atendimento.........................................:");
            System.out.println(".............[1]Abrir Conta.......................................");
            System.out.println(".............[2]Fechar Conta......................................");
            System.out.println(".............[2]Editar Conta......................................");
            System.out.println(".............[0]Voltar............................................");
            menu = in.nextInt();
            switch (menu) {

                case 1: {
                    menuAbrirConta();
                }
                break;
                // atendimmento em balcao
                case 2: {
                    menuFecharConta();
                }
                break;
                case 3: {
                    menuEditarConta();
                }
                break;
            }
        } while (menu != 0);
    }

    void menuAbrirConta() {
        int menu;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............Abertura de Conta...................................:");
            System.out.println(".............[1]Mesa..............................................");
            System.out.println(".............[2]Balcão............................................");
            System.out.println(".............[0]Voltar............................................");
            menu = in.nextInt();
            switch (menu) {
                case 1: {
                    menuMesa();
                }
                break;
                case 2: {
                    menuBalcao();
                }
                break;
            }
        } while (menu != 0);
    }

    void menuFecharConta() {
        int menu;
        int numMesa;
        int numCliente;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............Fechamento de Conta.................................:");
            System.out.println(".............[1]Mesa..............................................");
            System.out.println(".............[2]Balcão............................................");
            System.out.println(".............[0]Voltar............................................");
            menu = in.nextInt();
            switch (menu) {
                case 1: {
                    System.out.println(".............Informe O Numero da mesa:..................");
                    numMesa = in.nextInt();
                    Mesa auxMesa = this.getMesa(numMesa);
                    double gorjetatemp;
                    for (Clientes aux : auxMesa.tempClientes) {
                        System.out.println("Digite o valor da Gorjeta");
                        gorjetatemp = in.nextDouble();
                        aux.setGorjeta(gorjetatemp);
                    }
                    this.fecharContaMesa(numMesa);
                }
                break;
                case 2: {
                    System.out.println(".............Informe O Numero da Conta:..................");
                    numCliente = in.nextInt();
                    Clientes auxCliente = this.bar.getCliente(numCliente);
                    double gorjetatemp;

                    System.out.println("Digite o valor da Gorjeta");
                    gorjetatemp = in.nextDouble();
                    auxCliente.setGorjeta(gorjetatemp);
                    System.out.println("### FECHAMENTO DE CONTA ###");
                    auxCliente.fecharContaCliente();
                }
                break;
            }
        } while (menu != 0);
    }

    void menuEditarConta() {
        int menu;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............Atendimento.........................................:");
            System.out.println(".............[1]Mesa..............................................");
            System.out.println(".............[2]Balcão............................................");
            System.out.println(".............[0]Voltar............................................");
            menu = in.nextInt();
            switch (menu) {
                case 1: {

                }
                break;
                case 2: {

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
                System.out.println("");
                System.out.println("NOVO PEDIDO - [0]Sair ");
                //System.out.println("");
                System.out.println("Numero do item: ");
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
        xMesa.print();

    }

    void menuBalcao() {
        int garcom;
        int pessoa;
        Balcao bar = null;

        int numItem; // recebe pedidos do cliente
        int qtdItem;
        double valorUni;

        System.out.println("Informe o numero do garçom para atendê-lo:");
        garcom = in.nextInt();
        this.abrirContaBalcao(garcom); // informar numero do garçom

        Clientes xCliente = this.abrirContaBalcao(garcom);
        do {
            System.out.println("");
            System.out.println("NOVO PEDIDO - [0]Sair ");
            System.out.println("Numero do item: ");
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

    }

    /*void menuEditarBalcao() {
        do {
            System.out.println("............Editar Pedido......................");
            System.out.println("............[1]SIM.............................");
            System.out.println("............[0]NÃO.............................");
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
    
    void menuEditarMesa() {
        do {
            System.out.println("............Editar Pedido......................");
            System.out.println("............[1]SIM.............................");
            System.out.println("............[0]NÃO.............................");
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

    }*/
}

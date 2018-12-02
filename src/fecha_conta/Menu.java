package fecha_conta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author emilysoueu
 */
public class Menu extends Restaurante {  // usar o mesmo construtor de Restaurante

    Menu(int numGarcom, int NumItens, int numMesas, double gorjetatotal, double pagamentototal, double totalrestaurante) {
        super(numGarcom, NumItens, numMesas, gorjetatotal, pagamentototal, totalrestaurante);
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
            System.out.println(".............[3]Editar Conta......................................");
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

                    //this.fecharContaBalcao(numCliente, gorjetatemp); //======== FECHANDO A CONTA DUAS VEZES ========//
                    this.fecharContaBalcao(numCliente, gorjetatemp); //======== FILES ========//

                    int listaAberto = this.bar.getTotalAberto();
                    if (listaAberto == 0) {
                        this.bar.setStatus(false);
                    }
                }
                break;
            }
        } while (menu != 0);
    }

    void menuEditarConta() {
        int menu;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............Edição de Conta..............................................:");
            System.out.println(".............[1]Mesa..............................................");
            System.out.println(".............[2]Balcão............................................");
            System.out.println(".............[0]Voltar............................................");
            menu = in.nextInt();
            switch (menu) {
                case 1: {
                    menuEditarMesa();
                }
                break;
                case 2: {
                    menuEditarBalcao();
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

        Mesa xMesa = this.abrirContaMesa(qtdCliente, garcom, numMesa);
        xMesa.setGarcom(garcom);
        xMesa.setQtdClientes(qtdCliente);

        //int i=1;
        for (Clientes aux : xMesa.tempClientes) {
            //System.out.println("\nPEDIDO CLIENTE Nº"+ i++ +": ");
            System.out.println("\nPEDIDO CLIENTE Nº" + aux.num + ": ");

            do {
                System.out.println("");
                System.out.println("NOVO PEDIDO - [0]Sair ");
                this.cardapio();
                System.out.println("Numero do item: ");
                numItem = in.nextInt();

                if (numItem == 0) {
                    break;
                }

                System.out.println("Quantidade do item: ");
                qtdItem = in.nextInt();

                valorUni = this.matrizCardapio[numItem - 1];

                aux.addPedido(numItem, qtdItem, valorUni);

                aux.printPedido();

            } while (numItem != 0);
        }

        System.out.println("### MESA ATENDIDA ###");
        xMesa.print();
    }

    void menuEditarMesa() {
        int numMesa;
        System.out.println("Informe o numero da mesa:");
        numMesa = in.nextInt();

        Mesa xMesa = this.listaMesa.get(numMesa - 1);

        System.out.println("Digite o numero da conta ");
        int numCliente = in.nextInt();

        Clientes xCliente = xMesa.tempClientes.get(numCliente - 1);

        int pedido, del;
        do {
            System.out.println(".............[1]Adicionar Pedido ..............--------------.....");
            System.out.println(".............[2]Deletar Item Pedido................--------------.");
            System.out.println(".............[0]Voltar............................................");
            pedido = in.nextInt();
            switch (pedido) {

                case 1: {
                    int numItem; // recebe pedidos do cliente
                    int qtdItem;
                    double valorUni;
                    do {
                        System.out.println("");
                        System.out.println("NOVO PEDIDO - [0]Sair ");
                        this.cardapio();
                        System.out.println("Numero do item: ");
                        numItem = in.nextInt();

                        if (numItem == 0) {
                            break;
                        }

                        System.out.println("Quantidade do item: ");
                        qtdItem = in.nextInt();

                        valorUni = this.matrizCardapio[numItem - 1];

                        xCliente.addPedido(numItem, qtdItem, valorUni);
                        xCliente.printPedido();

                    } while (numItem != 0);
                }
                break;
                case 2: {
                    System.out.println("\n..............Informe o numero do Item:......");
                    del = in.nextInt();
                    xCliente.delItem(del);
                }
                break;
            }

            System.out.println("### CLIENTE ATENDIDO - PEDIDO COM ALTERAÇÃO ###");
            xCliente.printCliente();
            xCliente.printPedido();

        } while (pedido != 0);
    }

    void menuBalcao() {
        int garcom;

        int numItem; // recebe pedidos do cliente
        int qtdItem;
        double valorUni;

        System.out.println("Informe o numero do garçom para atendê-lo:");
        garcom = in.nextInt();

        Clientes xCliente = this.abrirContaBalcao(garcom);
        do {
            System.out.println("");
            System.out.println("NOVO PEDIDO - [0]Sair ");
            this.cardapio();
            System.out.println("Numero do item: ");
            numItem = in.nextInt();

            if (numItem == 0) {
                break;
            }

            System.out.println("Quantidade do item: ");
            qtdItem = in.nextInt();

            valorUni = this.matrizCardapio[numItem - 1];

            xCliente.addPedido(numItem, qtdItem, valorUni);
            xCliente.printPedido();

        } while (numItem != 0);

        System.out.println("### CLIENTE ATENDIDO ###");
        xCliente.printCliente();
    }

    void menuEditarBalcao() {

        System.out.println("Digite o numero da conta ");
        int numCliente = in.nextInt();

        Clientes xCliente = this.bar.getCliente(numCliente);
        int pedido, del;
        do {
            System.out.println(".............[1]Adicionar Pedido ..............--------------.....");
            System.out.println(".............[2]Deletar Item Pedido................--------------.");
            System.out.println(".............[0]Sair..............................................");
            pedido = in.nextInt();
            switch (pedido) {

                case 1: {
                    int numItem; // recebe pedidos do cliente
                    int qtdItem;
                    double valorUni;
                    do {
                        System.out.println("");
                        System.out.println("NOVO PEDIDO - [0]Sair ");
                        this.cardapio();
                        System.out.println("Numero do item: ");
                        numItem = in.nextInt();

                        if (numItem == 0) {
                            break;
                        }

                        System.out.println("Quantidade do item: ");
                        qtdItem = in.nextInt();

                        valorUni = this.matrizCardapio[numItem - 1];

                        xCliente.addPedido(numItem, qtdItem, valorUni);
                        xCliente.printPedido();

                    } while (numItem != 0);
                }
                break;
                case 2: {
                    System.out.println("\n..............Informe o numero do Item:......");
                    del = in.nextInt();
                    xCliente.delItem(del);
                }
                break;
            }

            System.out.println("### CLIENTE ATENDIDO - PEDIDO COM ALTERAÇÃO ###");
            xCliente.printCliente();
            xCliente.printPedido();

        } while (pedido != 0);
    }

    @Override
    public String toString() {
        String bos = "";

        bos += "Relatórios";
        bos += "\n\n\n";
        bos += "RELATORIO BALCAO:";
        bos += "\n";
        bos += "Gorjeta:" + bar.getGorjeta() + " | Pagamentos: " + bar.getTotal();
        bos += "\n\n\n";
        bos += "RELATORIO POR MESA:";
        bos += "\n";
        int i = 1;
        for (Mesa aux : this.listaMesa) {
            aux.setGorjeta();
            bos += "Gorjeta Mesa " + i++ + ": " + aux.getGorjeta() + "   | Pagamentos: " + aux.getTotal();
            bos += "\n";
            this.gorjetatotal += aux.getGorjeta();
            this.pagamentototal += aux.getTotal();
        }

        bos += "\n\n\n";
        bos += "RELATORIO GARÇOM";
        bos += "\n";
        for (i = 0; i < 5; i++) {
            bos += "Gorjeta Garcom Nº" + (i + 1) + ": " + matrizGarcom[i];
            bos += "\n";
        }

        bos += "\n\n\n";
        bos += "TOTAL";
        bos += "\n\n\n";
        bos += "Total Restaurante Poneis Dourados";
        bos += this.totalrestaurante = this.gorjetatotal + this.pagamentototal;
        bos += "\n";
        bos += "Total Diário (Pagamentos): " + this.pagamentototal;
        bos += "\n";
        bos += "Total Diário (Gorjeta): " + this.gorjetatotal;
        bos += "\n";
        bos += "Total Diário (Pagamentos + Gorjeta): " + this.totalrestaurante;
        bos += "\n";

        return bos;
    }

}

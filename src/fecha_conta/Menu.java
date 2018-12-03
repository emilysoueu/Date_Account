package fecha_conta;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;

/**
 * @author emilysoueu
 */
public class Menu extends Restaurante {  // usar o mesmo construtor de Restaurante

    Menu(int numGarcom, int NumItens, int numMesas, double gorjetatotal, double pagamentototal, double totalrestaurante) { //construtor menu/restaurante
        super(numGarcom, NumItens, numMesas, gorjetatotal, pagamentototal, totalrestaurante);
    }

    Scanner in = new Scanner(System.in); //entrada de dados

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
                case 1: {
                    menuManager(); // Interface Gerente
                }
                break;
                case 2: {
                    menuClient(); // Interface Cliente
                }
                break;
            }
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
                case 1: {
                    menuDescricao(); //menu para descrições
                }
                break;
                case 2: {
                    menuRelatorio(); //menu para emissao de relatorio
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
                case 1: { // descrição de uma mesa especifica

                    do { //loop de recebimento de numero da mesa válido
                        System.out.println("Informe o numero da mesa: ( 1 - 10 ) ");
                        numMesa = in.nextInt();
                    } while (numMesa > this.listaMesa.size() || numMesa < 1);

                    Mesa aux = this.getMesa(numMesa);
                    aux.print();
                }
                break;

                case 2: { //descrição do balcão
                    this.bar.print();
                }
                break;
                case 3: { // descrição de todas as mesas e do balcão
                    this.descricao();
                }
                break;
            }
        } while (manager != 0);
    }

    void menuRelatorio() {
        int manager = 0;

        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............[1]Contas em Aberto..................................");
            System.out.println(".............[2]Total Diário......................................");
            System.out.println(".............[3]Garcom............................................");
            System.out.println(".............[0]Voltar............................................");
            manager = in.nextInt();

            switch (manager) {

                case 1: { // relatorio de contas em aberto
                    this.relatorioAberto();
                }
                break;
                case 2: { // relatorio do total arrecardado no dia
                    this.relatorioFinal();
                }
                break;
                case 3: { // relatorio do total a cada garcom
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

                case 1: { //menu para abertura de conta
                    menuAbrirConta();
                }
                break;
                case 2: { // menu para fechamento de conta
                    menuFecharConta();
                }
                break;
                case 3: { //menu para edição de conta
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
                case 1: { //menu para abertura de conta do tipo mesa
                    menuMesa();
                }
                break;
                case 2: { // menu para abertura de conta no balcao
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

                    do { //loop de recebimento de numero da mesa válido
                        System.out.println("Informe o numero da mesa: ( 1 - 10 ) ");
                        numMesa = in.nextInt();
                    } while (numMesa > this.listaMesa.size() || numMesa < 1);

                    Mesa xMesa = this.getMesa(numMesa);

                    if (xMesa.getStatus() == false) { //verificação de conta estiver fechada não é possivel fechar novamente
                        System.out.println("Conta Fechada\n");
                        return;
                    }

                    double gorjetatemp;
                    for (Clientes aux : xMesa.tempClientes) { //loop de recebimento do valor da gorjeta para cada cliente
                        System.out.println("Digite o valor da Gorjeta");
                        gorjetatemp = in.nextDouble();
                        aux.setGorjeta(gorjetatemp);
                    }
                    this.fecharContaMesa(numMesa); //chama fechamento da conta da mesa escolhida
                }
                break;
                case 2: {

                    do { // loop de recebimento do numero da conta valido
                        System.out.println("Digite o numero da conta:");
                        numCliente = in.nextInt();
                    } while (numCliente > this.bar.listaCliente.size() || numCliente < 1);

                    Clientes xCliente = this.bar.getCliente(numCliente);

                    if (xCliente.getStatusConta() == false) { //se conta estiver fechada, não é possivel fechar novamente
                        System.out.println("Conta Fechada\n");
                        return;
                    }

                    double gorjetatemp;
                    System.out.println("Digite o valor da Gorjeta");
                    gorjetatemp = in.nextDouble(); // recebimento da gorjeta
                    xCliente.setGorjeta(gorjetatemp); //adicionando gorjeta ao cliente

                    System.out.println("### FECHAMENTO DE CONTA ###");

                    this.fecharContaBalcao(numCliente, gorjetatemp); //fechamento da conta do cliente e sua gotjeta

                    int listaAberto = this.bar.getTotalAberto(); //verificação se o numero de contas aberta é igual a 0 para setar obalcao como vazio
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
                case 1: { //menu para edição de conta mesa
                    menuEditarMesa();
                }
                break;
                case 2: { //menu para edição de conta balcao
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

        int numItem;
        int qtdItem;
        double valorUni;

        System.out.println("Informe a quantidade de Clientes na mesa:");
        qtdCliente = in.nextInt(); //recebimento do numero de cliente na mesa

        do { //loop para escolha de um garcom valido
            System.out.println("Informe o numero do garçom para atendê - lo: ( 1 - 5 )");;
            garcom = in.nextInt();
        } while (garcom > this.matrizGarcom.length || garcom < 1);

        do { // loop para escolhar de uma mesa valida
            System.out.println("Informe o numero da mesa: ( 1 - 10 ) ");
            numMesa = in.nextInt();
        } while (numMesa > this.listaMesa.size() || numMesa < 1);

        Mesa xMesa = this.abrirContaMesa(qtdCliente, garcom, numMesa); //instaciação de uma mesa
        xMesa.setGarcom(garcom); //seta o garcomo da mesa apartir do primeiro cliente
        xMesa.setQtdClientes(qtdCliente); //seta a quantidade de clientes nos dados da mesa

        for (Clientes aux : xMesa.tempClientes) { //loop para realizar pedido para cada cliente da mesa
            System.out.println("\nPEDIDO CLIENTE Nº" + aux.getNum() + ": ");

            do { //loop que permite um cliente realizar quantos pedidos desejar
                System.out.println("");
                System.out.println("NOVO PEDIDO - [0]Sair ");
                this.cardapio(); //instanciando cardápio

                do { //loop de escolhar de um item válido
                    System.out.println("Numero do item: ( 0 - 3 )");
                    numItem = in.nextInt();
                } while (numItem > this.matrizCardapio.length || numItem < 0);

                if (numItem == 0) { //encerramento do pedido
                    break;
                }

                System.out.println("Quantidade do item: ");
                qtdItem = in.nextInt(); //recebimento da quantidade de items

                valorUni = this.matrizCardapio[numItem - 1]; //acessa o cardário no item especificado para pegar preço

                aux.addPedido(numItem, qtdItem, valorUni); //adicionar o predido criado no arraylist de pedidos do cliente

                aux.printPedido(); //imprimite o pedido feito

            } while (numItem != 0);
        }

        System.out.println("### MESA ATENDIDA ###");
        xMesa.print(); //imprimite dados da mesa atendida
    }

    void menuEditarMesa() {
        int numMesa;
        int numCliente;

        do { //escolha de uma mesa valida
            System.out.println("Informe o numero da mesa: ( 1 - 10 ) ");
            numMesa = in.nextInt();
        } while (numMesa > this.listaMesa.size() || numMesa < 1);

        Mesa xMesa = this.listaMesa.get(numMesa - 1); //pega mesa valida

        if (xMesa.getStatus() == false) { //verificação de conta esta aberta para continuar a modificar
            System.out.println("Conta Fechada\n");
            return;
        }

        do { //escolhar de conta valida
            System.out.println("Digite o numero da conta:");
            numCliente = in.nextInt();
        } while (numCliente > xMesa.tempClientes.size() || numCliente < 1);

        Clientes xCliente = xMesa.tempClientes.get(numCliente - 1); //pega cliente especifico

        int pedido, del;
        do {
            System.out.println(".............[1]Adicionar Pedido ..............--------------.....");
            System.out.println(".............[2]Deletar Item Pedido................--------------.");
            System.out.println(".............[0]Voltar............................................");
            pedido = in.nextInt();
            switch (pedido) {

                case 1: { //adicionar pedido
                    int numItem;
                    int qtdItem;
                    double valorUni;
                    do {
                        System.out.println("");
                        System.out.println("NOVO PEDIDO - [0]Sair ");
                        this.cardapio(); //instanciar cardapior

                        do { //escolhar de um intem valido do cardápio
                            System.out.println("Numero do item: ( 0 - 3 )");
                            numItem = in.nextInt();
                        } while (numItem > this.matrizCardapio.length || numItem < 0);

                        if (numItem == 0) { //encerra pedido
                            break;
                        }

                        System.out.println("Quantidade do item: ");
                        qtdItem = in.nextInt(); //aicionar quantidade do item

                        valorUni = this.matrizCardapio[numItem - 1]; //pega valor unitario da matrizcardápio

                        xCliente.addPedido(numItem, qtdItem, valorUni); //adicionar pedido na lista de pedidos
                        xCliente.printPedido(); //imprimide pedido

                    } while (numItem != 0);
                }
                break;
                case 2: { //deleta pedido
                    System.out.println("\n..............Informe o numero do Item:......");
                    del = in.nextInt(); //deleta o item se o item existir
                    xCliente.delItem(del);
                }
                break;
            }

            System.out.println("### CLIENTE ATENDIDO - PEDIDO COM ALTERAÇÃO ###");
            xCliente.printCliente(); //imprimite dados do cliente
            xCliente.printPedido(); //imprimite dados do pedido

        } while (pedido != 0);
    }

    void menuBalcao() {
        int garcom;

        int numItem; // recebe pedidos do cliente
        int qtdItem;
        double valorUni;

        do { //escolhar de um cargom válido
            System.out.println("Informe o numero do garçom para atendê - lo: ( 1 - 5 )");;
            garcom = in.nextInt();
        } while (garcom > this.matrizGarcom.length || garcom < 1);

        Clientes xCliente = this.abrirContaBalcao(garcom); //abertura de uma conta

        System.out.println("\nPEDIDO CLIENTE Nº" + xCliente.getNum() + ": ");
        do {
            System.out.println("");
            System.out.println("NOVO PEDIDO - [0]Sair ");
            this.cardapio(); //instancia o cardápio

            do { //loop para escolhar de um item valido do cardápio
                System.out.println("Numero do item: ( 0 - 3 )");
                numItem = in.nextInt();
            } while (numItem > this.matrizCardapio.length || numItem < 0);

            if (numItem == 0) { //encerra o pedido
                break;
            }

            System.out.println("Quantidade do item: ");
            qtdItem = in.nextInt(); //recebe a quantidade de cada item

            valorUni = this.matrizCardapio[numItem - 1]; //pega-se o valor unitário de cada item do cardápio em especifico

            xCliente.addPedido(numItem, qtdItem, valorUni); //adicionar pedido
            xCliente.printPedido(); //imprimi pedido

        } while (numItem != 0);

        System.out.println("### CLIENTE ATENDIDO ###");
        xCliente.printCliente(); //imprimite dados do cliente
    }

    void menuEditarBalcao() {

        int numCliente, pedido, del;

        do { //loop para escolhar de uma conta valida
            System.out.println("Digite o numero da conta:");
            numCliente = in.nextInt();
        } while (numCliente > this.bar.listaCliente.size() || numCliente < 1);

        Clientes xCliente = this.bar.getCliente(numCliente); //pega-se o cliente em especifico

        if (xCliente.getStatusConta() == false) { //se conta estiver fechada, não é possivel editar
            System.out.println("Conta Fechada\n");
            return;
        }

        do {
            System.out.println(".............[1]Adicionar Pedido ..............--------------.....");
            System.out.println(".............[2]Deletar Item Pedido................--------------.");
            System.out.println(".............[0]Sair..............................................");
            pedido = in.nextInt();
            switch (pedido) {

                case 1: {
                    int numItem;
                    int qtdItem;
                    double valorUni;
                    do {
                        System.out.println("");
                        System.out.println("NOVO PEDIDO - [0]Sair ");
                        this.cardapio(); //instancia cardápio

                        do { //loop de escolhar de um item do cardápio valido
                            System.out.println("Numero do item: ( 0 - 3 )");
                            numItem = in.nextInt();
                        } while (numItem > this.matrizCardapio.length || numItem < 0);

                        if (numItem == 0) { //encerra pedido
                            break;
                        }

                        System.out.println("Quantidade do item: ");
                        qtdItem = in.nextInt(); //adicionar a quantidade do item

                        valorUni = this.matrizCardapio[numItem - 1]; //pega-se valor unitário do item da matriz cardápio

                        xCliente.addPedido(numItem, qtdItem, valorUni); //adicionar pedido
                        xCliente.printPedido(); //imprimi pedido

                    } while (numItem != 0);
                }
                break;
                case 2: {
                    System.out.println("\n..............Informe o numero do Item:......");
                    del = in.nextInt();
                    xCliente.delItem(del); //deleta item se o item estiver na lista
                }
                break;
            }

            System.out.println("### CLIENTE ATENDIDO - PEDIDO COM ALTERAÇÃO ###");
            xCliente.printCliente(); //imprime dados do cliente
            xCliente.printPedido(); //imprimite dados do cliente

        } while (pedido != 0);
    }

    @Override
    public String toString() {
        String bos = "";

        bos += "Relatórios";
        bos += "\n\n\n";
        bos += "RELATORIO BALCAO:";
        bos += "\n";
        bos += "Gorjeta:" + this.bar.getGorjeta() + " | Pagamentos: " + this.bar.getTotal();
        bos += "\n\n\n";
        bos += "RELATORIO POR MESA:";
        bos += "\n";
        int i = 1;

        for (Mesa aux : this.listaMesa) {
            //aux.setGorjeta();
            bos += "Gorjeta Mesa " + i++ + ": " + aux.getGorjeta() + "   | Pagamentos: " + aux.getTotal();
            bos += "\n";
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
        bos += "\n";
        bos += "Total Diário (Pagamentos): " + this.getPagamentototal();
        bos += "\n";
        bos += "Total Diário (Gorjeta): " + this.getGorjetatotal();
        bos += "\n";
        bos += "Total Diário (Pagamentos + Gorjeta): " + this.getTotalrestaurante();
        bos += "\n";

        return bos;
    }

}

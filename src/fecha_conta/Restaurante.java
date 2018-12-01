package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    ArrayList<Mesa> listaMesa;
    double[] matrizGarcom;
    double[] matrizCardapio;
    Balcao bar;

    public Restaurante(int numGarcom, int NumItens, int numMesas) {
        this.listaMesa = new ArrayList<>(); //declaração e instanciamento do arraylist listaMesa
        this.matrizGarcom = new double[5/*numGarcom*/]; //declaração e instanciamento da matriz matrizGarcom
        this.matrizCardapio = new double[5/*NumItens*/]; //declaração e instanciamento da matriz matrizCardapio

        //instanciando o objeto bar do tipo balcao
        this.bar = new Balcao(0, 0, 0); // averiguar isso aqui        

        //instanciando a quantidade "numMesas" de objetos do tipo Mesa e adicionando na listaMesa
        for (int i = 0; i < 10/*numMesas*/; i++) {
            this.listaMesa.add(new Mesa(0, 0, 0, 0, 0, true));
        }
    }

    void cardapio() {
        System.out.println(" Item 1 ---- $1");
        System.out.println(" Item 2 ---- $200");
        System.out.println(" Item 3 ---- $500");

        this.matrizCardapio[0] = 1;
        this.matrizCardapio[1] = 200;
        this.matrizCardapio[2] = 500;
    }

    /*void criarBalcao(int aberta, int fechada, int g) {
        Balcao b = new Balcao(aberta, fechada, g);
    }

    void criarMesa(int abertaQtd, int fechadaQtd, int g, int qtdClientes, int totalMesa, boolean statusMesa) {
         listaMesa.add(new Mesa(abertaQtd, fechadaQtd,  g,  qtdClientes,  totalMesa,  statusMesa));
    }*/
    public Balcao getBar() {
        return bar;
    }

    public void setBar(Balcao bar) {
        this.bar = bar;
    }

    public double getValorGarcomMatriz(int indice) {
        return this.matrizGarcom[indice - 1];
    }

    public void setValorGarcomMatriz(int indice, double valor) {
        this.matrizGarcom[indice - 1] = valor;
    }

    public double getValorCardapio(int indice) {
        return this.matrizCardapio[indice - 1];
    }

    public void setValorCardapio(int indice, double valor) {
        this.matrizCardapio[indice - 1] = valor;
    }

    public Clientes abrirContaBalcao(int garcom) {
        Clientes c = new Clientes(true, garcom);
        this.bar.listaCliente.add(c);
        return c;
    }

    public Mesa abrirContaMesa(int qtdClientes, int garcom, int numMesa) {
        Mesa atual = this.listaMesa.get(numMesa - 1);

        atual.setGarcom(garcom);
        atual.setQtdClientes(qtdClientes);

        for (int i = 0; i < qtdClientes; i++) {
            Clientes c = new Clientes(true, garcom);
            atual.listaCliente.add(c);
            atual.tempClientes.add(c);
        }
        return atual;
    }

    public void fecharContaBalcao(int numCliente) {
        this.bar.listaCliente.get(numCliente - 1).fecharContaCliente();
    }

    public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1);

        System.out.println("Total da Mesa: " + mesaAtual.getTotalMesa());

        int i = 1;
        for (Clientes aux : mesaAtual.tempClientes) {
            System.out.println("Cliente: " + i);
            aux.fecharContaCliente();
        }

        mesaAtual.fecharContaMesa();

    }

    /*public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1);

        System.out.println("Total da Mesa: " + mesaAtual.getTotalMesa());

        for (int i = 0; i < mesaAtual.tempClientes.size(); i++) {
            System.out.println("Total por Cliente" + i + ": " + mesaAtual.tempClientes.get(i).total);
            mesaAtual.tempClientes.get(i).fecharContaCliente();
        }

        mesaAtual.tempClientes.clear();
        mesaAtual.statusMesa = false;
        mesaAtual.totalMesa = 0;
    }*/
    public int getTotalAberto() {
        int t = 0;

        for (Mesa aux : listaMesa) {

            t += aux.getTotalAberto();
        }

        t += bar.getTotalAberto();

        return t;
    }

    public int getTotalFechado() {
        int t = 0;

        for (Mesa aux : listaMesa) {

            t += aux.getTotalFechado();
        }

        t += bar.getTotalFechado();

        return t;
    }

    Scanner in = new Scanner(System.in);

    public void menu() {
        int menu, user, manager;
        int numMesa;
        do {
            System.out.println(".............Restaurante Poneis Dourados..........................");
            System.out.println(".............[1]Administração.....................................");
            System.out.println(".............[2]Usuário...........................................");
            System.out.println(".............[0]Sair...........................................");
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

    }

}

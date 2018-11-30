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
        this.matrizGarcom = new double[numGarcom]; //declaração e instanciamento da matriz matrizGarcom
        this.matrizCardapio = new double[NumItens]; //declaração e instanciamento da matriz matrizCardapio

        //instanciando o objeto bar do tipo balcao
        this.bar = new Balcao(0, 0, 0); // averiguar isso aqui        

        //instanciando a quantidade "numMesas" de objetos do tipo Mesa e adicionando na listaMesa
        for (int i = 0; i < numMesas; i++) {
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

    void setValorGarcomMatriz(int indice, double valor) {
        this.matrizGarcom[indice - 1] = valor;
    }

    public double getValorCardapio(int indice) {
        return this.matrizCardapio[indice - 1];
    }

    public void setValorCardapio(int indice, double valor) {
        this.matrizCardapio[indice - 1] = valor;
    }

    public void abrirContaBalcao(int garcom) {
        Clientes c = new Clientes(true, garcom);
        this.bar.listaCliente.add(c);
    }

    public void abrirContaMesa(int qtdClientes, int garcom, int numMesa) {
        for (int i = 0; i < qtdClientes; i++) {
            Clientes c = new Clientes(true, garcom);
            this.listaMesa.get(numMesa - 1).listaCliente.add(c);
            this.listaMesa.get(numMesa - 1).tempClientes.add(c);
        }
    }

    public void fecharContaBalcao(int numCliente) {
        this.bar.listaCliente.get(numCliente - 1).fecharContaCliente();
    }

    public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1);

        System.out.println("Total da Mesa: " + mesaAtual.getTotalMesa());

        for (int i = 0; i < mesaAtual.tempClientes.size(); i++) {
            System.out.println("Total por Cliente" + i + ": " + mesaAtual.tempClientes.get(i).total);
            mesaAtual.tempClientes.get(i).fecharContaCliente();
        }

        mesaAtual.tempClientes.clear();
        mesaAtual.statusMesa = false;
        mesaAtual.totalMesa = 0;
    }

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
        int menu;

        System.out.println(".............Bem Vindo ao Restaurante Poneis Dourados............");
        System.out.println(".............Atendimento........................................:");
        System.out.println(".............[1]Mesa.............................................");
        System.out.println(".............[2]Balcao...........................................");
        menu = in.nextInt();

        switch (menu) {
            // atendimento em mesa
            case 1: {
                int qtdCliente;
                int garcom;
                int numMesa;

                int numItem; // recebe pedidos do cliente
                int qtdItem;
                int valorUni;

                System.out.println("Informe a quantidade de Clientes na mesa:");
                qtdCliente = in.nextInt();
                System.out.println("Informe o numero do garçom para atendê - lo:");
                garcom = in.nextInt();
                System.out.println("Informe o numero da mesa:");
                numMesa = in.nextInt();
                this.abrirContaMesa(qtdCliente, garcom, numMesa);

                Mesa atual = this.listaMesa.get(numMesa - 1);

                //.tempClientes.add(c);
                for (Clientes aux : atual.tempClientes) {

                    do {
                        System.out.println("Numero do item: ");
                        numItem = in.nextInt();

                        System.out.println("Quantidade do item: ");
                        qtdItem = in.nextInt();
                        
                        System.out.println("Qual o valor unitário do item: ");
                        valorUni = in.nextInt();                    
                        
                        aux.addPedido(numItem, qtdItem, valorUni);                        

                    } while (numItem != 0);

                }

            }
            // atendimmento em balcao
            case 2: {
                int garcom;

                System.out.println("Informe o numero do garçom para atendê-lo:");
                garcom = in.nextInt();
                this.abrirContaBalcao(garcom); // informar numero do garçom         

            }
        }

    }

}

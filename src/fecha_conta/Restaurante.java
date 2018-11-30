package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

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

    void abrirContaBalcao(int garcom) {
        Clientes c = new Clientes(true, garcom);
        this.bar.listaCliente.add(c);
    }

    void abrirContaMesa(int qtdClientes, int garcom, int numMesa) {
        for (int i = 0; i < qtdClientes; i++) {
            Clientes c = new Clientes(true, garcom);
            this.listaMesa.get(numMesa - 1).listaCliente.add(c);
            this.listaMesa.get(numMesa - 1).tempClientes.add(c);
        }
    }

    void fecharContaBalcao(int numCliente) {
        this.bar.listaCliente.get(numCliente - 1).fecharContaCliente();
    }

    void fecharContaMesa(int numMesa) {
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

    int getTotalAberto() {
        int t = 0;

        for (Mesa aux : listaMesa) {

            t += aux.getTotalAberto();
        }

        t += bar.getTotalAberto();

        return t;
    }

    int getTotalFechado() {
        int t = 0;

        for (Mesa aux : listaMesa) {

            t += aux.getTotalFechado();
        }

        t += bar.getTotalFechado();

        return t;
    }

}

package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Restaurante {

    double[] garcommatriz;
    ArrayList<Mesa> listaMesa; // 5 mesas - capacidade
    Balcao bar;
    int[] cardapio;// 5 itens pra teste

    public Restaurante() {
        this.garcommatriz = new double[3];
        this.listaMesa = new ArrayList<>();
        this.bar = new Balcao(0, 0, 0); // averiguar isso aqui
        this.cardapio = new int[3];

        for (int i = 0; i < 5; i++) {
            this.listaMesa.add(new Mesa(0, 0, 0, 0, 0, true));
        }
    }

    void cardapio() {
        System.out.println(" Item 1 ---- $1");
        System.out.println(" Item 2 ---- $200");
        System.out.println(" Item 3 ---- $500");

        this.cardapio[0] = 1;
        this.cardapio[1] = 200;
        this.cardapio[2] = 500;
    }

    /*void criarBalcao(int aberta, int fechada, int g) {
        Balcao b = new Balcao(aberta, fechada, g);
    }

    void criarMesa(int abertaQtd, int fechadaQtd, int g, int qtdClientes, int totalMesa, boolean statusMesa) {
         listaMesa.add(new Mesa(abertaQtd, fechadaQtd,  g,  qtdClientes,  totalMesa,  statusMesa));
    }*/
    void addvalor(int indice, double valor) {
        this.garcommatriz[indice - 1] = valor;
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

        System.out.println("Total da Mesa: " + mesaAtual.getTotal());

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

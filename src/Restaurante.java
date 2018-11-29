
/**
 *
 * @author emilysoueu
 */
import java.util.ArrayList;

public class Restaurante {

    double[] garcommatriz;
    ArrayList<Mesa> listaMesa; // 5 mesas - capacidade
    Balcao bar = new Balcao(0, 0, 0);;
    int[] cardapio;// 5 itens pra teste

    public Restaurante() {
        this.garcommatriz = new double[3];
        this.listaMesa = new ArrayList<>();
        this.bar = bar; // averiguar isso aqui
        this.cardapio = new int[3];

    }

    void cardapio() {
        System.out.println(" Item 1 ---- $1");
        System.out.println(" Item 2 ---- $200");
        System.out.println(" Item 3 ---- $500");

        this.cardapio[0] = 1;
        this.cardapio[1] = 200;
        this.cardapio[2] = 500;
    }

    void criarBalcao(int aberta, int fechada, int g) {
        Balcao b = new Balcao(aberta, fechada, g);
    }

    void criarMesa(int abertaQtd, int fechadaQtd, int g, int qtdClientes, int totalMesa, boolean statusMesa) {
        for (int i = 0; i < 5; i++) {
            listaMesa.add(new Mesa(abertaQtd, fechadaQtd, g, qtdClientes, totalMesa, statusMesa));
        }
    }

    void addvalor(int indice, double valor) {
        this.garcommatriz[indice - 1] = valor;
    }

    void abrirContaBalcao(int garcom) {
        Clientes c = new Clientes(true, garcom);
        this.bar.listaCliente.add(c);
    }

    void abrirContaMesa(int garcom, int numMesa) {

        Clientes c = new Clientes(true, garcom);
        this.listaMesa[numMesa-1] = this.listaCliente.add(c);
    }

    void fecharConta() {

    }

}

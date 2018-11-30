package fecha_conta;

import java.util.ArrayList;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
public class Mesa extends Service {

    boolean statusMesa;//ocupa = true
    int qtdClientes;
    double totalMesa;//conta da mesa
    //int[] tempClientes;
    ArrayList<Clientes> tempClientes;

    Mesa(int abertaQtd, int fechadaQtd, int g, int qtdClientes, int totalMesa, boolean statusMesa) {
        super(abertaQtd, fechadaQtd, g);
        this.qtdClientes = qtdClientes;
        this.totalMesa = totalMesa; // total das contas de todos os clientes na mesa
        this.statusMesa = statusMesa; // saber se todas as pessoas estão estão com a contas fechadas
        //this.tempClientes = new int[qtdClientes]; // controle de clientes na mesa
        this.tempClientes = new ArrayList<>();
    }

    void setqtdCliente(int qtd) {
        this.qtdClientes = qtd;
    }

    int getqtdClientes() {
        return this.qtdClientes;
    }

    void setstatusMesa(boolean temp) {
        this.statusMesa = temp;
    }

    boolean statusMesa() {
        return this.statusMesa;
    }

    double getTotal() {
        for (Clientes temp : tempClientes) {
            this.totalMesa += temp.total;
        }
        return totalMesa;
    }

}

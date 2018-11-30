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

    public boolean getStatusMesa() {
        return statusMesa;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.statusMesa = statusMesa;
    }

    public int getQtdClientes() {
        return qtdClientes;
    }

    public void setQtdClientes(int qtdClientes) {
        this.qtdClientes = qtdClientes;
    }

    public double getTotalMesa() {
        return totalMesa;
    }

    public void setTotalMesa(double totalMesa) {
        for (Clientes temp : tempClientes) {
            this.totalMesa += temp.total;
        }
        this.totalMesa = totalMesa;
    }

    public void print() {
        int i = 1;
        for (Clientes aux : tempClientes) {
            System.out.println("Numero do Cliente:" + i++);
            aux.print();
        }
    }

}

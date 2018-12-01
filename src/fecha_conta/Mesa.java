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
    ArrayList<Clientes> tempClientes;
    double tempGorjeta;
    //int[] tempClientes;

    Mesa(int abertaQtd, int fechadaQtd, int g, double gorjeta, int qtdClientes, int totalMesa, boolean statusMesa) {
        super(abertaQtd, fechadaQtd, g, gorjeta);
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

    public void fecharContaMesa() {
        this.setTotalMesa();
        this.setGorjeta();
        this.setTempGorjeta();
        this.printMesa();
        System.out.println("Valor Total: " + this.totalMesa);
        System.out.println("Gorjeta Total: " + this.tempGorjeta);

        this.tempClientes.clear();
        this.statusMesa = false;
        this.totalMesa = 0;
        this.gorjeta = 0;
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

    public void setTotalMesa() {
        for (Clientes temp : tempClientes) {
            this.totalMesa += temp.total;
        }
        this.totalMesa = totalMesa;
    }

    public void setTempGorjeta() {
        for (Clientes aux : this.tempClientes) {
            this.tempGorjeta += aux.getGorjeta();
        }

    }

    public void printMesa() {
        System.out.println("Mesa Ocupada: " + this.getStatusMesa());
        System.out.println("Numero do Garcom: " + this.garcom);
        System.out.println("Quantidade de Clientes: " + this.qtdClientes);
        //System.out.println("Valor Total: " + this.totalMesa);
        System.out.println("");
    }

    public void printClientesMesa() {
        int i = 1;
        System.out.println("");
        for (Clientes aux : tempClientes) {
            System.out.println("Numero do Cliente:" + i++);
            aux.printCliente();
            aux.printPedido();
        }
        System.out.println("");
    }

}

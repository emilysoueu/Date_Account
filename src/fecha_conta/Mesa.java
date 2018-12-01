package fecha_conta;

import java.util.ArrayList;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
public class Mesa extends Service {

    int qtdClientes;
    double totalMesa;//conta da mesa
    ArrayList<Clientes> tempClientes;
    double tempGorjeta;
    //boolean statusMesa;//ocupa = true
    //int[] tempClientes;

    Mesa(int abertaQtd, int fechadaQtd, int g, double gorjeta, int qtdClientes, int totalMesa, boolean statusMesa) {
        super(abertaQtd, fechadaQtd, g, gorjeta);
        this.qtdClientes = qtdClientes;
        this.totalMesa = totalMesa; // total das contas de todos os clientes na mesa
        this.status = statusMesa; // saber se todas as pessoas estão estão com a contas fechadas
        //this.tempClientes = new int[qtdClientes]; // controle de clientes na mesa
        this.tempClientes = new ArrayList<>();
    }

    public boolean getStatusMesa() {
        return status;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.status = statusMesa;
    }

    public void fecharContaMesa() {
        this.setTotalMesa();
        this.setGorjeta();
        this.setTempGorjeta();
        //this.print();
        System.out.println("");
        System.out.println("Valor Total: " + this.totalMesa);
        System.out.println("Gorjeta Total: " + this.tempGorjeta);
        System.out.println("");

        this.tempClientes.clear();
        this.status = false;
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

    @Override
    public void print() {
        System.out.println("Mesa Ocupada: " + this.getStatusMesa());
        System.out.println("Numero do Garcom: " + this.garcom);
        System.out.println("Quantidade de Clientes: " + this.qtdClientes);
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

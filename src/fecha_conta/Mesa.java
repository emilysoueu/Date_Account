package fecha_conta;

import java.util.ArrayList;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
public class Mesa extends Service {

    private int qtdClientes;
    private double totalMesa;//conta da mesa    
    private double tempGorjeta;
    ArrayList<Clientes> tempClientes;
    //boolean statusMesa;//ocupa = true
    //int[] tempClientes;

    Mesa(int abertaQtd, int fechadaQtd, int g, double gorjeta, int qtdClientes, int totalMesa, boolean status) {
        super(abertaQtd, fechadaQtd, g, gorjeta, status);
        this.qtdClientes = qtdClientes;
        this.totalMesa = totalMesa; // total das contas de todos os clientes na mesa
        //this.status = statusMesa; // saber se todas as pessoas estão estão com a contas fechadas
        //this.tempClientes = new int[qtdClientes]; // controle de clientes na mesa
        this.tempClientes = new ArrayList<>();
    }

    /*public boolean getStatusMesa() {
        return status;
    }

    public void setStatusMesa(boolean statusMesa) {
        this.status = statusMesa;
    }*/
    public void fecharContaMesa() {
        this.setTotalMesa();
        this.setGorjeta();
        this.setTempGorjeta();

        System.out.println("### VALOR TOTAL MESA ###");
        System.out.println("Valor Total: " + this.totalMesa);
        System.out.println("Gorjeta Total: " + this.tempGorjeta);
        System.out.println("");

        this.tempClientes.clear();
        //this.status = false;
        this.setStatus(false);
        this.totalMesa = 0;
        //this.gorjeta = 0;
        this.zerarGorjeta();
        this.qtdClientes = 0;
        //this.garcom = 0;
        this.setGarcom(0);
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
        for (Clientes aux : tempClientes) {
            this.totalMesa += aux.getTotal();
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
        System.out.println("Mesa Ocupada: " + this.getStatus());
        //System.out.println("Numero do Garcom: " + this.garcom);
        System.out.println("Numero do Garcom: " + this.getGarcom());
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

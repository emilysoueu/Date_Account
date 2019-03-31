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

    Mesa(int abertaQtd, int fechadaQtd, int g, double gorjeta, int qtdClientes, int totalMesa, double tempGorjeta, boolean status) {
        super(abertaQtd, fechadaQtd, g, gorjeta, status);
        this.qtdClientes = qtdClientes;
        this.totalMesa = totalMesa; // total das contas de todos os clientes na mesa
        this.tempGorjeta = tempGorjeta;
        this.tempClientes = new ArrayList<>();
    }

    //metodo para fecharconta mesa
    public void fecharContaMesa() {
        this.setTotalMesa(); //calcula o total da mesa somando o total de todos os clientes
        this.setGorjeta(); // calcula gorjeta somando a gorjeta de todos os clientes
        this.setTempGorjeta(); //calcula uma gorjeta temporaria

        System.out.println("### VALOR TOTAL MESA ###");
        System.out.println("Valor Total: " + this.totalMesa);
        System.out.println("Gorjeta Total: " + this.tempGorjeta);
        System.out.println("");

        this.tempClientes.clear(); //limpa a lista de cliente de cada mesa
        this.setStatus(false); //volta o valor padrao de mesa desocupada
        this.totalMesa = 0; //zera o valor total da mesa
        this.zerarGorjeta(); //zera a forjeta da mesa
        this.qtdClientes = 0; //zera a quantidade de clientes
        this.setGarcom(0); //volta o garcom pro padrão
    }

    //acessa o atributo total de clientes
    public int getQtdClientes() {
        return qtdClientes;
    }

    //altera o valor do atributo de numero de clientes
    public void setQtdClientes(int qtdClientes) {
        this.qtdClientes = qtdClientes;
    }

    //acessa o valor total da mesa
    public double getTotalMesa() {
        return totalMesa;
    }

    //calcula o valor total da mesa, somando o valor de cada cliente
    public void setTotalMesa() {
        for (Clientes aux : tempClientes) {
            this.totalMesa += aux.getTotal();
        }
        this.totalMesa = totalMesa;
    }

    //calcula o valor da gorjeta da mesa, somando a gorjeta de todos os clientes
    public void setTempGorjeta() {
        for (Clientes aux : this.tempClientes) {
            this.tempGorjeta += aux.getGorjeta();
        }
    }

    @Override // função de impressão do dados da mesa
    public void print() {
        System.out.println("Mesa Ocupada: " + this.getStatus());
        System.out.println("Numero do Garcom: " + this.getGarcom());
        System.out.println("Quantidade de Clientes: " + this.qtdClientes);
        System.out.println("");
    }

    //impresa dos dados de cada cliente da mesa
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

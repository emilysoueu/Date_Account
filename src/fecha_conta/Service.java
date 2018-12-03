package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Service {

    private int totalFechado; // contas em aberto
    private int totalAberto; // contas fechadas
    private int garcom;
    private double gorjeta;
    private boolean status;
    private double total;
    ArrayList<Clientes> listaCliente;

    public Service(int totalFechado, int totalAberto, int garcom, double gorjeta, boolean status) {
        this.totalAberto = totalAberto;
        this.totalFechado = totalFechado;
        this.listaCliente = new ArrayList<>();
        this.garcom = garcom;
        this.status = status;
    }

    //metodo para acessar o atributo privado garcom
    public int getGarcom() {
        return garcom;
    }

    //metodo para alterar o numero do garcom 
    public void setGarcom(int garcom) {
        this.garcom = garcom;
    }

    //metodo para retornar um cliente em especifico
    public Clientes getCliente(int numCliente) {
        return this.listaCliente.get(numCliente - 1);
    }

    //metodo para acessar o atributo privado total
    public double getTotal() {
        return total;
    }

    //metodo para calcular o total do dia no balcao ou garcom
    public void setTotal(double total) {
        this.total += total;
    }

    //metodo para acessar o atributo privado status
    public boolean getStatus() {
        return status;
    }

    //metodo para alterar o valor boleano privado
    public void setStatus(boolean status) {
        this.status = status;
    }

    //metodo para acessar o total de contas em aberto privado
    public int getTotalAberto() {
        return this.totalAberto;
    }

    //metodo para calcular o total de contas em aberto
    public void setTotalAberto() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.getStatusConta() == true) {
                t += 1;
            }
        }
        this.totalAberto = t;
    }

    //metodo para calcular o numero de clientes com a conta fechada
    public void setTotalFechado() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.getStatusConta() == false) {
                t += 1;
            }
        }
        this.totalFechado = t;
    }

    //metodo para acessar o total de clientes com contas fechadas
    public int getTotalFechado() {
        return totalFechado;
    }

    //metodo para acessar a gorjeta privada
    public double getGorjeta() {
        return gorjeta;
    }

    //zera a gorjeta ao fechar a conta
    public void zerarGorjeta() {
        this.gorjeta = 0;
    }

    //funcao de calculo de gorjeta para todos os clientes do balcao ou por mesa
    public void setGorjeta() {
        for (Clientes aux : this.listaCliente) {
            this.gorjeta += aux.getGorjeta();
        }
    }

    //impressao dos dados do cliente e seus respectivos pedidos
    public void relatorioAberto() {
        //int i = 1;
        for (Clientes aux : this.listaCliente) {
            if (aux.getStatusConta() == true) {
                System.out.println("Cliente Nº" + aux.getNum() + ": ");
                aux.printCliente();
                aux.printPedido();
            }
        }
    }

    // função de impressão do dados da mesa e balcao
    public void print() {
        System.out.println("Ocupado(a): " + this.status);
        System.out.println("Numero do Garcom: " + this.garcom);

        int i = 0;
        for (Clientes aux : this.listaCliente) {
            if (aux.getStatusConta() == true) {
                i += 1;
            }
        }
        System.out.println("Quantidade de Clientes: " + i);
        System.out.println("");
    }

}

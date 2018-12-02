package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Service {

    ArrayList<Clientes> listaCliente;
    int totalFechado; // contas em aberto
    int totalAberto; // contas fechadas
    int garcom;
    double gorjeta;
    boolean status;
    double total;

    public Service(int totalFechado, int totalAberto, int garcom, double gorjeta) {
        this.totalAberto = totalAberto;
        this.totalFechado = totalFechado;
        this.listaCliente = new ArrayList<>();
        this.garcom = garcom;
    }

    public int getGarcom() {
        return garcom;
    }

    public Clientes getCliente(int numCliente) {
        return this.listaCliente.get(numCliente - 1);
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setGarcom(int garcom) {
        this.garcom = garcom;
    }

    public int getTotalAberto() {
        return this.totalAberto;
    }

    public void setTotalAberto() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.getStatusConta() == true) {
                t += 1;
            }
        }
        this.totalAberto = t;
    }

    public void setTotalFechado() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.getStatusConta() == false) {
                t += 1;
            }
        }
        this.totalFechado = t;
    }

    public int getTotalFechado() {
        return totalFechado;
    }

    public double getGorjeta() {
        return gorjeta;
    }

    public void setGorjeta() {
        for (Clientes aux : this.listaCliente) {
            this.gorjeta += aux.getGorjeta();
        }
    }

    /*void clienteDelItem(int numCliente, int numItem) {
        int i = 1;
        for (Clientes aux : this.listaCliente) {
            i++;
            if (i == numCliente) {
                aux.delItem(numItem);
                System.out.println("\n Item alterado com sucesso\n");
            }
        }
    }*/
    public void relatorioAberto() {
        int i = 1;
        for (Clientes aux : this.listaCliente) {
            if (aux.getStatusConta() == true) {
                System.out.println("Cliente Nº" + i++ + ": ");
                aux.printCliente();
                aux.printPedido();
            }
        }
    }

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

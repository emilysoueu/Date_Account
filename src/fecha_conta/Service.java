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
    
    public Service(int totalFechado, int totalAberto, int garcom, double gorjeta) {
        this.totalAberto = totalAberto;
        this.totalFechado = totalFechado;
        this.listaCliente = new ArrayList<>();
        this.garcom = garcom;
    }
    
    public int getGarcom() {
        return garcom;
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
            if (aux.statusConta == true) {
                t += 1;
            }
        }
        this.totalAberto = t;
    }
    
    public void setTotalFechado() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.statusConta == false) {
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
    
    void clienteDelItem(int numCliente, int numItem) {
        int i = 1;
        for (Clientes aux : this.listaCliente) {
            i++;
            if (i == numCliente) {
                aux.delItem(numItem);
                System.out.println("\n Item alterado com sucesso\n");                
            }
            
        }
    }
    

    public void relatorioAberto() {
        for (Clientes aux : this.listaCliente) {
            if (aux.statusConta == true) {
                aux.printCliente();
                aux.printPedido();
            }
        }
    }    
    

}


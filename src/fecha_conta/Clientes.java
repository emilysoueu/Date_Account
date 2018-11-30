package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Clientes {

    boolean statusConta; //true aberta
    ArrayList<Item> listaItens;
    int garcom;
    //int Atendimento;// 0 = Balcao e 1 = Mesa
    double total;

    public Clientes(boolean statusConta, int garcom/*, int Atendimento*/) {
        this.statusConta = statusConta;
        this.garcom = garcom;
        //this.Atendimento = Atendimento; // 0 = Balcao e 1 = Mesa
        this.listaItens = new ArrayList<>();
    }

    // ============================métodos===============================//
    public void addPedido(int numItem, int qtdItem, double valorUni) {
        Item item = new Item(numItem, qtdItem, valorUni, qtdItem * valorUni);
        this.listaItens.add(item);
    }

    public void delItem(int itemtemp) {
        for (Item aux : this.listaItens) {
            if (itemtemp == aux.numItem) {
                this.listaItens.remove(aux);
            }
        }
    }

    public boolean getStatusConta() {
        return statusConta;
    }

    /*public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }*/
    public void fecharContaCliente() {
        this.statusConta = false;
    }

    public int getGarcom() {
        return garcom;
    }

    public void setGarcom(int garcom) {
        this.garcom = garcom;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void print() {
        int i = 1;
        for (Item aux : this.listaItens) {
            System.out.println("Pedido Numero:" + i++);
            System.out.println("Numero de items: " + aux.numItem);
            System.out.println("Quantidade de items: " + aux.qtdItem);
            System.out.println("Valor Unitário: " + aux.valorUni);
            System.out.println("Valor Total: " + aux.valorTot);
            System.out.println("");
        }
    }

}

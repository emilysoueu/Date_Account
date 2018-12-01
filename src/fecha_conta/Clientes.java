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
        this.total = this.setTotal();
        this.printCliente();
        System.out.println("Valor Total:" + this.getTotal());
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

    public double setTotal() {
        for (Item aux : this.listaItens) {
            this.total += aux.getValorTot();
        }
        return this.total;
    }

    public void printCliente() {

        System.out.println("Numero do Garcom: " + this.getGarcom());
        System.out.println("Conta em Aberto: " + this.getStatusConta());
        //System.out.println("Valor Total: " + this.getTotal());
        System.out.println("");

    }

    public void printPedido() {
        int i = 1;
        for (Item aux : this.listaItens) {
            System.out.println("PEDIDO NUMERO:" + i++);
            aux.printItem();
            System.out.println("");
        }
    }

}

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
    double total;
    double gorjeta;
    int num;
    //int Atendimento;// 0 = Balcao e 1 = Mesa

    public Clientes(boolean statusConta, int garcom, int num/*, int Atendimento*/) {
        this.statusConta = statusConta;
        this.garcom = garcom;
        //this.Atendimento = Atendimento; // 0 = Balcao e 1 = Mesa
        this.listaItens = new ArrayList<>();
        this.num = num + 1;
    }

    // ============================métodos===============================//
    public void addPedido(int numItem, int qtdItem, double valorUni) {
        Item item = new Item(numItem, qtdItem, valorUni, qtdItem * valorUni);
        this.listaItens.add(item);
    }

    public void delItem(int itemtemp) {
        for (Item aux : this.listaItens) {
            if (aux.getNumItem() == itemtemp) {
                this.listaItens.remove(aux);
                break;
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
        this.setTotal();
        this.getGorjeta();
        this.printCliente();
        this.printPedido();
        System.out.println("# Valor Total Cliente #");
        System.out.println("Valor Total:" + this.total);
        System.out.println("Gorjeta: " + this.gorjeta);
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

    public void setTotal() {
        for (Item aux : this.listaItens) {
            this.total += aux.getValorTot();
        }
    }

    public double getGorjeta() {
        return gorjeta;
    }

    public void setGorjeta(double gorjeta) {
        this.gorjeta = gorjeta;
    }

    public void printCliente() {
        System.out.println("Numero do Cliente: " + this.num);
        System.out.println("Numero do Garcom: " + this.garcom);
        System.out.println("Conta em Aberto: " + this.statusConta);
        System.out.println("Quantidade de Pedidos: " + this.listaItens.size());
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

package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Clientes {

    private boolean statusConta; //true aberta    
    private int garcom;
    private double total;
    private double gorjeta;
    private int num;

    ArrayList<Item> listaItens;
    //int Atendimento;// 0 = Balcao e 1 = Mesa

    public Clientes(boolean statusConta, int garcom, int num/*, int Atendimento*/) {
        this.statusConta = statusConta;
        this.garcom = garcom;
        //this.Atendimento = Atendimento; // 0 = Balcao e 1 = Mesa
        this.listaItens = new ArrayList<>();
        this.num = num + 1;
    }

    //metodos para acicionar pedidos
    public void addPedido(int numItem, int qtdItem, double valorUni) {
        Item item = new Item(numItem, qtdItem, valorUni, qtdItem * valorUni);
        this.listaItens.add(item);
    }

    //metodo para deletar um pedido especifico
    public void delItem(int itemtemp) {
        for (Item aux : this.listaItens) {
            if (aux.getNumItem() == itemtemp) {
                this.listaItens.remove(aux);
                break;
            }
        }
    }

    //metodo para acessar o atributo privado de status da conta
    public boolean getStatusConta() {
        return statusConta;
    }

    //metodo para alterar o atributo privado de status do cliente
    public void setStatusConta(boolean statusConta) {
        this.statusConta = statusConta;
    }

    //acessar o atributo privado de numero do cliente
    public int getNum() {
        return num;
    }

    //alterar/ definir o valor de numero do cliente
    public void setNum(int num) {
        this.num = num;
    }

    //atributo para fechamento de conta cliente 
    public void fecharContaCliente() {
        this.statusConta = false; //altera o status da conta
        this.setTotal(); // realiza calculo de total
        this.getGorjeta(); // acessa a gorjeta
        this.printCliente(); //imprimi dados do cliente
        this.printPedido(); //imprimi dados do pedido
        System.out.println("# Valor Total Cliente #");
        System.out.println("Valor Total:" + this.total);
        System.out.println("Gorjeta: " + this.gorjeta);
    }

    //metodos de acesso ao atributo privado garcom
    public int getGarcom() {
        return garcom;
    }

    //metodo para alterar atributo garcom
    public void setGarcom(int garcom) {
        this.garcom = garcom;
    }

    //metodo de acesso ao valor total do cliente
    public double getTotal() {
        return total;
    }

    //metodo de calculo do valor total do cliente, realizando a soma do valor de todos os itens
    public void setTotal() {
        for (Item aux : this.listaItens) {
            this.total += aux.getValorTot();
        }
    }

    //metodo de acesso ao atributo privado gorjeta
    public double getGorjeta() {
        return gorjeta;
    }

    //metodo de alteração do valor do atributo privado gorjeta
    public void setGorjeta(double gorjeta) {
        this.gorjeta = gorjeta;
    }

    //metodo para impressao de dados cliente
    public void printCliente() {
        System.out.println("Numero do Cliente: " + this.num);
        System.out.println("Numero do Garcom: " + this.garcom);
        System.out.println("Conta em Aberto: " + this.statusConta);
        System.out.println("Quantidade de Pedidos: " + this.listaItens.size());
        System.out.println("");
    }

    //metodo para impressao dos dados do pedido
    public void printPedido() {
        int i = 1;
        for (Item aux : this.listaItens) {
            System.out.println("PEDIDO NUMERO:" + i++);
            aux.printItem();
            System.out.println("");
        }
    }

}

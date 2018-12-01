package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
public class Item {

    private int numItem;
    private int qtdItem;
    private double valorUni;
    private double valorTot;

    Item(int numItem, int qtdItem, double valorUni, double valorTot) {
        this.numItem = numItem;
        this.qtdItem = qtdItem;
        this.valorUni = valorUni;
        this.valorTot = valorTot;
    }

    public int getNumItem() {
        return numItem;
    }

    public void setNumItem(int numItem) {
        this.numItem = numItem;
    }

    public int getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(int qtdItem) {
        this.qtdItem = qtdItem;
    }

    public double getValorUni() {
        return valorUni;
    }

    public void setValorUni(double valorUni) {
        this.valorUni = valorUni;
    }

    public double getValorTot() {
        return valorTot;
    }

    public void setValorTot() {
        this.valorTot = this.numItem * this.valorUni;
    }

    public void printItem() {
        System.out.println("Numero do item: " + this.numItem);
        System.out.println("Quantidade do item: " + this.qtdItem);
        System.out.println("Valor Unitário: " + this.valorUni);
        System.out.println("Valor Total: " + this.valorTot);
        System.out.println("");
    }

}

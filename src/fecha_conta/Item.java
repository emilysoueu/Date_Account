package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
public class Item {

    int numItem;
    int qtdItem;
    double valorUni;
    double valorTot;

    Item(int numItem, int qtdItem, double valorUni, double valorTot) {
        this.numItem = numItem;
        this.qtdItem = qtdItem;
        this.valorTot = valorUni;
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

    public void setValorTot(double valorTot) {
        this.valorTot = valorTot;
    }

}

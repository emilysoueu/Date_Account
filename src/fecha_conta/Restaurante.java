package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    ArrayList<Mesa> listaMesa;
    double[] matrizGarcom;
    double[] matrizCardapio;
    Balcao bar;

    public Restaurante(int numGarcom, int NumItens, int numMesas) {
        this.listaMesa = new ArrayList<>(); //declaração e instanciamento do arraylist listaMesa
        this.matrizGarcom = new double[5/*numGarcom*/]; //declaração e instanciamento da matriz matrizGarcom
        this.matrizCardapio = new double[5/*NumItens*/]; //declaração e instanciamento da matriz matrizCardapio

        //instanciando o objeto bar do tipo balcao
        this.bar = new Balcao(0, 0, 0, 0); // averiguar isso aqui        

        //instanciando a quantidade "numMesas" de objetos do tipo Mesa e adicionando na listaMesa
        for (int i = 0; i < 10/*numMesas*/; i++) {
            this.listaMesa.add(new Mesa(0, 0, 0, 0, 0, 0, false));
        }
    }

    void cardapio() {
        System.out.println(" Item 1 ---- $1");
        System.out.println(" Item 2 ---- $200");
        System.out.println(" Item 3 ---- $500");

        this.matrizCardapio[0] = 1;
        this.matrizCardapio[1] = 200;
        this.matrizCardapio[2] = 500;
    }

    public Balcao getBar() {
        return bar;
    }

    public void setBar(Balcao bar) {
        this.bar = bar;
    }
    
    public Mesa getMesa(int numMesa){
        return this.listaMesa.get(numMesa-1);
    }

    public double getValorGarcomMatriz(int indice) {
        return this.matrizGarcom[indice - 1];
    }

    public void setValorGarcomMatriz(int indice, double valor) {
        this.matrizGarcom[indice - 1] = valor;
    }

    public double getValorCardapio(int indice) {
        return this.matrizCardapio[indice - 1];
    }

    public void setValorCardapio(int indice, double valor) {
        this.matrizCardapio[indice - 1] = valor;
    }

    public Clientes abrirContaBalcao(int garcom) {
        Clientes c = new Clientes(true, garcom);
        this.bar.listaCliente.add(c);
        return c;
    }

    public Mesa abrirContaMesa(int qtdClientes, int garcom, int numMesa) {
        Mesa atual = this.listaMesa.get(numMesa - 1);

        atual.setGarcom(garcom);
        atual.setQtdClientes(qtdClientes);
        atual.status = true;

        for (int i = 0; i < qtdClientes; i++) {
            Clientes c = new Clientes(true, garcom);
            atual.listaCliente.add(c);
            atual.tempClientes.add(c);
        }
        return atual;
    }

    public void fecharContaBalcao(int numCliente) {
        Clientes atual = this.bar.listaCliente.get(numCliente - 1);
        atual.fecharContaCliente();
        int numGarcom = atual.getGarcom();
        matrizGarcom[numGarcom - 1] += atual.getGorjeta();
    }

    public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1);
        int i = 1;
        for (Clientes aux : mesaAtual.tempClientes) {
            System.out.println("Cliente: " + i++);
            aux.fecharContaCliente();
            System.out.println("");
            int numGarcom = aux.getGarcom();
            matrizGarcom[numGarcom - 1] += aux.getGorjeta();
        }
        mesaAtual.fecharContaMesa();
        System.out.println("");
    }

    /*public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1);

        System.out.println("Total da Mesa: " + mesaAtual.getTotalMesa());

        for (int i = 0; i < mesaAtual.tempClientes.size(); i++) {
            System.out.println("Total por Cliente" + i + ": " + mesaAtual.tempClientes.get(i).total);
            mesaAtual.tempClientes.get(i).fecharContaCliente();
        }

        mesaAtual.tempClientes.clear();
        mesaAtual.statusMesa = false;
        mesaAtual.totalMesa = 0;
    }*/
    public int getTotalAberto() {
        int t = 0;
        for (Mesa aux : listaMesa) {
            t += aux.getTotalAberto();
        }

        t += bar.getTotalAberto();

        return t;
    }

    public int getTotalFechado() {
        int t = 0;
        for (Mesa aux : listaMesa) {
            t += aux.getTotalFechado();
        }

        t += bar.getTotalFechado();

        return t;
    }

    public void descricao() {

        System.out.println("Descrição do Balcão: ");
        this.bar.print();
        System.out.println("");

        int i = 1;
        System.out.println("Descrição de Todas as Mesas: ");
        for (Mesa aux : listaMesa) {
            System.out.println("Mesa " + i++ + " : ");
            aux.print();
            System.out.println("");
        }
    }

    //o Emitir relatório de contas em aberto (em atendimento)
    public void relatorioAberto() {
        System.out.println("CONTAS EM ABERTO - BALCAO");
        bar.relatorioAberto();
        System.out.println("");

        System.out.println("CONTAS EM ABERTO - MESA");
        int i = 1;
        for (Mesa aux : this.listaMesa) {
            System.out.println("MESA Nº: " + i++);
            aux.relatorioAberto();
            System.out.println("");
        }
    }

    //o Emitir total apurado no dia
    public void relatorioFinal() {
        System.out.println("RELATORIO BALCAO:");
        System.out.println(bar.getGorjeta());
        System.out.println("");

        System.out.println("RELATORIO POR MESA:");
        int i = 1;
        for (Mesa aux : this.listaMesa) {
            System.out.println("Gorjeta Mesa " + i++ + ": " + aux.getGorjeta());
            System.out.println("");
        }
    }

    //o Emitir relatório de gorjetas por garçom
    public void relatorioGarcom() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Gorjeta Garcom Nº" + i + ": " + matrizGarcom[i]);
            System.out.println("");
        }
    }

}

package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;
import java.util.Scanner;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.util.Scanner;
import java.util.Scanner;

public class Restaurante {

    ArrayList<Mesa> listaMesa;
    double[] matrizGarcom;
    double[] matrizCardapio;
    Balcao bar;
    double gorjetatotal;
    double pagamentototal;
    double totalrestaurante;

    public Restaurante(int numGarcom, int NumItens, int numMesas, double gorjetatotal, double pagamentototal, double totalrestaurante) {
        this.listaMesa = new ArrayList<>(); //declaração e instanciamento do arraylist listaMesa
        this.matrizGarcom = new double[5/*numGarcom*/]; //declaração e instanciamento da matriz matrizGarcom
        this.matrizCardapio = new double[5/*NumItens*/]; //declaração e instanciamento da matriz matrizCardapio
        this.totalrestaurante = totalrestaurante;
        //instanciando o objeto bar do tipo balcao
        this.bar = new Balcao(0, 0, 0, 0); // averiguar isso aqui        

        //instanciando a quantidade "numMesas" de objetos do tipo Mesa e adicionando na listaMesa
        for (int i = 0; i < 10/*numMesas*/; i++) {
            this.listaMesa.add(new Mesa(0, 0, 0, 0, 0, 0, false));
        }
    }
    /////////////////////////////==========FILES==========//////////////////////////////////////////////////////

    /*
    @novoArquivo = caminho da pasta onde vai ser gerado novo arquivo
     */
    public void escritor(String novoArquivo, String relatorios) throws IOException {
        try (BufferedWriter buffEscreve = new BufferedWriter(new FileWriter(novoArquivo))) {
            String linha = "";
            linha = relatorios;
            buffEscreve.append(linha + "\n");
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////
    public void cardapio() {
        System.out.println("........Cardápio.......");
        System.out.println("1 - Pizza--------- $50");
        System.out.println("2 - Lazanha------- $40");
        System.out.println("3 - Macarronada--- $30");

        this.matrizCardapio[0] = 50;
        this.matrizCardapio[1] = 40;
        this.matrizCardapio[2] = 30;
    }

    public Balcao getBar() {
        return bar;
    }

    public void setBar(Balcao bar) {
        this.bar = bar;
    }

    public Mesa getMesa(int numMesa) {
        return this.listaMesa.get(numMesa - 1);
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
        this.bar.setGarcom(garcom);
        this.bar.setStatus(true);
        return c;
    }

    public Mesa abrirContaMesa(int qtdClientes, int garcom, int numMesa) {
        Mesa atual = this.listaMesa.get(numMesa - 1);

        atual.setGarcom(garcom);
        atual.setQtdClientes(qtdClientes);
        atual.setStatus(true);

        for (int i = 0; i < qtdClientes; i++) {
            Clientes c = new Clientes(true, garcom);
            atual.listaCliente.add(c);
            atual.tempClientes.add(c);
        }
        return atual;
    }

    public void fecharContaBalcao(int numCliente, double gorjeta) {
        Clientes atual = this.bar.listaCliente.get(numCliente - 1);
        atual.fecharContaCliente();
        this.bar.total += atual.getTotal();
        int numGarcom = atual.getGarcom();
        matrizGarcom[numGarcom - 1] += gorjeta;
    }

    public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1);
        System.out.println("### FECHAMENTO DE CONTA ###");
        int i = 1;
        for (Clientes aux : mesaAtual.tempClientes) {
            System.out.println("# CLIENTE: " + i++);
            aux.fecharContaCliente();
            mesaAtual.total += aux.getTotal();
            System.out.println("");
            int numGarcom = aux.getGarcom();
            matrizGarcom[numGarcom - 1] += aux.getGorjeta();
        }
        mesaAtual.fecharContaMesa();
        System.out.println("");
    }

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
        this.bar.setGorjeta();
        System.out.println("RELATORIO BALCAO:");
        System.out.println("Gorjeta:" + bar.getGorjeta() + " | Pagamentos: " + bar.getTotal());
        System.out.println("");

        this.gorjetatotal += bar.getGorjeta();
        this.pagamentototal += bar.getTotal();

        System.out.println("RELATORIO POR MESA:");
        int i = 1;
        for (Mesa aux : this.listaMesa) {
            aux.setGorjeta();
            System.out.println("Gorjeta Mesa " + i++ + ": " + aux.getGorjeta() + " | Pagamentos: " + aux.getTotal());
            System.out.println("");

            this.gorjetatotal += aux.getGorjeta();
            this.pagamentototal += aux.getTotal();
        }

        this.totalrestaurante = this.gorjetatotal + this.pagamentototal;

        System.out.println("Total Diário (Pagamentos): " + this.pagamentototal);
        System.out.println("Total Diário (Gorjeta): " + this.gorjetatotal);
        System.out.println("Total Diário (Pagamentos + Gorjeta): " + this.totalrestaurante);
        System.out.println("");

    }

    //o Emitir relatório de gorjetas por garçom
    public void relatorioGarcom() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Gorjeta Garcom Nº" + (i + 1) + ": " + matrizGarcom[i]);
            System.out.println("");
        }
    }
    
    //============ teste arquivos====================//
    @Override
    public String toString() {
        String bos = "";
        bos += "RELATORIO BALCAO:";
        bos += "\n";
        bos += "Gorjeta:" + bar.getGorjeta() + " | Pagamentos: " + bar.getTotal();
        bos += "\n";
        bos += "RELATORIO POR MESA:";
        bos += "\n";
        for (Mesa aux : this.listaMesa) {
            int i = 1;
            aux.setGorjeta();
            bos += "Gorjeta Mesa " + i++ + ": " + aux.getGorjeta() + " | Pagamentos: " + aux.getTotal();
            System.out.println("");
            this.gorjetatotal += aux.getGorjeta();
            this.pagamentototal += aux.getTotal();
        }

        bos += "\n";
        bos += "Total Restaurante Poneis Dourados";
        bos += "\n";
        bos += this.totalrestaurante = this.gorjetatotal + this.pagamentototal;
        bos += "\n";
        bos += "Total Diário (Pagamentos): " + this.pagamentototal;
        bos += "\n";
        bos += "Total Diário (Gorjeta): " + this.gorjetatotal;
        bos += "\n";
        bos += "Total Diário (Pagamentos + Gorjeta): " + this.totalrestaurante;
        bos += "\n";

        return bos;
    }


}

package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Restaurante {

    Balcao bar;
    private double gorjetatotal;
    private double pagamentototal;
    private double totalrestaurante;

    double[] matrizGarcom;
    double[] matrizCardapio;
    ArrayList<Mesa> listaMesa;

    public Restaurante(int numGarcom, int NumItens, int numMesas, double gorjetatotal, double pagamentototal, double totalrestaurante) {
        this.listaMesa = new ArrayList<>(); //declaração e instanciamento do arraylist listaMesa
        this.matrizGarcom = new double[5/*numGarcom*/]; //declaração e instanciamento da matriz matrizGarcom
        this.matrizCardapio = new double[5/*NumItens*/]; //declaração e instanciamento da matriz matrizCardapio
        this.totalrestaurante = totalrestaurante;
        //instanciando o objeto bar do tipo balcao
        this.bar = new Balcao(0, 0, 0, 0, false); // averiguar isso aqui        

        //instanciando a quantidade "numMesas" de objetos do tipo Mesa e adicionando na listaMesa
        for (int i = 0; i < 10/*numMesas*/; i++) {
            this.listaMesa.add(new Mesa(0, 0, 0, 0, 0, 0, 0, false));
        }
    }

    //cardápio
    public void cardapio() {
        System.out.println("........Cardápio.......");
        System.out.println("1 - Pizza--------- $50");
        System.out.println("2 - Lazanha------- $40");
        System.out.println("3 - Macarronada--- $30");

        this.matrizCardapio[0] = 50;
        this.matrizCardapio[1] = 40;
        this.matrizCardapio[2] = 30;
    }

    //metodo para acessar a gorjeta total do restaurante
    public double getGorjetatotal() {
        return gorjetatotal;
    }

    //metodos para calcular a gorjeta total do restaurante
    public void setGorjetatotal(double gorjetatotal) {
        this.gorjetatotal += gorjetatotal;
    }

    //metodo para acessar o pagamento total do resturante
    public double getPagamentototal() {
        return pagamentototal;
    }

    //metodo para cacular o pagamento total do restaurante
    public void setPagamentototal(double pagamentototal) {
        this.pagamentototal += pagamentototal;
    }

    //metodo para acessar o atributo totalrestaurante
    public double getTotalrestaurante() {
        return totalrestaurante;
    }

    //metodo para calcular o total arrecadao pelo restaurante
    public void setTotalrestaurante(double totalrestaurante) {
        this.totalrestaurante = totalrestaurante;
    }

    //metodo para acessar o balcao
    public Balcao getBar() {
        return this.bar;
    }

    //metodo de definicao balcao
    public void setBar(Balcao bar) {
        this.bar = bar;
    }

    //metodos para retornar uma mesa em especifica
    public Mesa getMesa(int numMesa) {
        return this.listaMesa.get(numMesa - 1);
    }

    //metodo para acessar um garcom em especifico
    public double getValorGarcomMatriz(int indice) {
        return this.matrizGarcom[indice - 1];
    }

    //metodo de alteração de valores de gorjeta para um garcom em especifico
    public void setValorGarcomMatriz(int indice, double valor) {
        this.matrizGarcom[indice - 1] = valor;
    }

    //metodo para retorno de um valor de um item do cardapio em especifico
    public double getValorCardapio(int indice) {
        return this.matrizCardapio[indice - 1];
    }

    //metodo para alterar valor de um item do cardápio em especifico
    public void setValorCardapio(int indice, double valor) {
        this.matrizCardapio[indice - 1] = valor;
    }

    //metodo para instanciar e criar um cliente: setando como ocupado, numero do garcom passado por parametro e numero do cliente referente ao tamanho do array
    public Clientes abrirContaBalcao(int garcom) {
        Clientes c = new Clientes(true, garcom, this.bar.listaCliente.size());
        this.bar.listaCliente.add(c); //adicionar no array
        this.bar.setGarcom(garcom); //usa o garcom do ultimo cliente como garcom do balcao
        this.bar.setStatus(true); //altera o estado do balcao
        return c; //retorn o cliente criado para manipulação
    }

    //metodo para abertura de conta em uma mesa mesa
    public Mesa abrirContaMesa(int qtdClientes, int garcom, int numMesa) {
        Mesa atual = this.listaMesa.get(numMesa - 1);

        atual.setGarcom(garcom); // altera o garcom da mesa
        atual.setQtdClientes(qtdClientes); // definite o numero de clientes
        atual.setStatus(true); // seta como ocupada a mesa

        for (int i = 0; i < qtdClientes; i++) { // criação e instanciamento de varios clientes
            Clientes c = new Clientes(true, garcom, atual.tempClientes.size());
            atual.listaCliente.add(c); //adicionamento em lista cliente
            atual.tempClientes.add(c); //adicionamento em lista de clientes temporarias
        }
        return atual; //retorna a respectiva mesa manipulada
    }

    //fecha a conta do balcao casa a conta estiver aberta
    public void fecharContaBalcao(int numCliente, double gorjeta) {
        Clientes atual = this.bar.listaCliente.get(numCliente - 1);
        if (atual.getStatusConta() == false) { // verifica se a conta esta fechada para sair
            System.out.println("Conta Fechada");
            return;
        }
        atual.fecharContaCliente(); // metodo para fechamento de conta
        //this.bar.total += atual.getTotal();
        this.bar.setTotal(atual.getTotal()); //soma valor da conta a conta total do balcao
        int numGarcom = atual.getGarcom(); //pega garcom utilizado no atendimento
        matrizGarcom[numGarcom - 1] += gorjeta; //adiciona a gorjeta do cliente no garcom responsavel
    }

    //fecha conta da mesa se a conta estiver aberta
    public void fecharContaMesa(int numMesa) {
        Mesa mesaAtual = this.listaMesa.get(numMesa - 1); // seleciona-se amesa

        if (mesaAtual.getStatus() == false) { // verifica se a conta da mesa esta fechada
            System.out.println("Conta Fechada");
            return;
        }

        System.out.println("### FECHAMENTO DE CONTA ###");
        int i = 1;
        for (Clientes aux : mesaAtual.tempClientes) {
            System.out.println("# CLIENTE: " + i++);
            aux.fecharContaCliente(); //força o fechamento de conta de todos os clientes
            //mesaAtual.total += aux.getTotal();
            mesaAtual.setTotal(aux.getTotal()); // calcula e adicionar o total de todos os clientes temporarios da mesa ao total da mesa
            System.out.println("");
            int numGarcom = aux.getGarcom();
            matrizGarcom[numGarcom - 1] += aux.getGorjeta(); //pega-se o garcom especifico do atendimento e adicionar sua respectiva gorjeta
        }
        mesaAtual.fecharContaMesa(); //fechamento total da mesa
        System.out.println("");
    }

    //metodo de calculo de conta em aberto
    public int getTotalAberto() {
        int t = 0;
        for (Mesa aux : listaMesa) {
            t += aux.getTotalAberto();
        }
        t += this.bar.getTotalAberto();
        return t;
    }

    //metodo de calculo para contas fechadas
    public int getTotalFechado() {
        int t = 0;
        for (Mesa aux : listaMesa) {
            t += aux.getTotalFechado();
        }
        t += this.bar.getTotalFechado();
        return t;
    }

    //metodo para descrição de situação de cada mesa
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

    //o Emitir relatório de contas em aberto (em atendimento) acessando atributo da classe restaurante
    public void relatorioAberto() {
        System.out.println("CONTAS EM ABERTO - BALCAO");
        this.bar.relatorioAberto();

        System.out.println("CONTAS EM ABERTO - MESA");
        int i = 1;
        for (Mesa aux : this.listaMesa) {
            System.out.println("MESA Nº: " + i++);
            aux.relatorioAberto();
            System.out.println("");
        }
    }

    //o Emitir total apurado no dia acessando atributo da classe restaurante
    public void relatorioFinal() {
        this.bar.setGorjeta();
        System.out.println("RELATORIO BALCAO:");
        System.out.println("Gorjeta:" + this.bar.getGorjeta() + " | Pagamentos: " + this.bar.getTotal());
        System.out.println("");

        this.gorjetatotal += this.bar.getGorjeta();
        this.pagamentototal += this.bar.getTotal();

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

    //o Emitir relatório de gorjetas por garçom acessando atributo da classe restaurante
    public void relatorioGarcom() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Gorjeta Garcom Nº" + (i + 1) + ": " + matrizGarcom[i]);
            System.out.println("");
        }
    }

}

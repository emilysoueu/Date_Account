package fecha_conta;

/**
 *
 * @author emilysoueu, fernandodojo, kellyberreca
 */
import java.util.ArrayList;

public class Service {

    ArrayList<Clientes> listaCliente;
    int totalFechado;
    int totalAberto;
    int garcom;

    public Service(int totalFechado, int totalAberto, int garcom) {
        this.totalAberto = totalAberto;
        this.totalFechado = totalFechado;
        this.listaCliente = new ArrayList<>();
        this.garcom = garcom;
    }

    /**
     * @return the garcom
     */
    public int getGarcom() {
        return garcom;
    }

    /**
     * @param garcom the garcom to set
     */
    public void setGarcom(int garcom) {
        this.garcom = garcom;
    }

    /**
     * @param totalAberto the totalAberto to set
     */
    public void setTotalAberto() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.statusConta == true) {
                t += 1;
            }
        }
        this.totalAberto = t;
    }

    int getTotalAberto() {
        return this.totalAberto;
    }

    /**
     * @param totalFechado the totalFechado to set
     */
    public void setTotalFechado() {
        int t = 0;
        for (Clientes aux : listaCliente) {
            if (aux.statusConta == false) {
                t += 1;
            }
        }
        this.totalFechado = t;
    }

    /**
     * @return the totalFechado
     */
    public int getTotalFechado() {
        return totalFechado;
    }
}

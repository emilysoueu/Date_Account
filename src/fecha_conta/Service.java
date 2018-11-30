package fecha_conta;


/**
 *
 * @author emilysoueu
 */
import java.util.ArrayList;
public class Service {
     ArrayList<Clientes> listaCliente;
     int totalFechado;
     int totalAberto;
     int garcom;
     
     
     
     
    public Service ( int totalFechado, int totalAberto, int garcom){
        this.totalAberto = totalAberto;
        this.totalFechado = totalFechado;
        this.listaCliente = new ArrayList<>();
        this.garcom = garcom;
    }   
     
     //===== verifica as contas fechadas
     void calcularContas(){
         
     }
     
      
    
}

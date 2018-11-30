package fecha_conta;


/**
 *
 * @author emilysoueu
 */
import java.util.ArrayList;
public class Clientes {
    boolean statusConta;
    ArrayList<Item> listaItens;
    int garcom;
    //int Atendimento;// 0 = Balcao e 1 = Mesa
    double total;
    
    
    
   public Clientes(boolean statusConta, int garcom/*, int Atendimento*/){
       this.statusConta = statusConta;
       this.garcom = garcom; 
       //this.Atendimento = Atendimento; // 0 = Balcao e 1 = Mesa
       this.listaItens = new ArrayList<>();
   } 
   
  
    
    // ============================métodos===============================//
    
    void addPedido(Item aux){
        this.listaItens.add(aux);       
       
    }
    
    void delItem(int itemtemp){
       for( Item aux: this.listaItens){
           if(itemtemp == aux.numItem){
               this.listaItens.remove(aux);
           } 
       }
    }
    
    
   
    
   
    
}

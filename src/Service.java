/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author emilysoueu
 */
import java.util.ArrayList;
public class Service {
     ArrayList<Clientes> listaCliente;
     int totalFechado;
     int totalAberto;
     
     
     
    public Service ( int totalFechado, int totalAberto){
        this.totalAberto = totalAberto;
        this.totalFechado = totalFechado;
        this.listaCliente = new ArrayList<>();  
    }   
     
     //===== verifica as contas fechadas
     void calcularContas(){
         
     }
    
}

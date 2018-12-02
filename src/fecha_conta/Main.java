/*
 * @author emilysoueu, fernandodojo, kellyberreca
 */
package fecha_conta;

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

public class Main {

    public static void main(String[] args) {
        
        Restaurante churras = new Restaurante(2, 0, 4, 0, 0, 0);
        Menu menu = new Menu(2, 0, 4, 0, 0, 0); // mesmo construtor de restaurante

        menu.menu(); 
        
       
        // manipulação de arquivos //
        
        try{
            FileOutputStream saida = new FileOutputStream(new File("Relatorio Poneis Dourados.txt"));
            byte[] b = menu.toString().getBytes();
            saida.write(b);
        } catch (Exception e){
                        System.err.printf("An error occurred creating the file. %s.\n", e.getMessage());
            
            
        }
        
        
        
         
        
        

    }
}

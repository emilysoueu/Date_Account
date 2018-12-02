/*
 * @author emilysoueu, fernandodojo, kellyberreca
 */
package fecha_conta;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileOutputStream;



public class Main {

    public static void main(String[] args) {
        
        Restaurante churras = new Restaurante(2, 0, 4, 0, 0, 0);
        Menu menu = new Menu(2, 0, 4, 0, 0, 0); // mesmo construtor de restaurante

        menu.menu(); 
        String nomeArquivo = "Relatorio Poneis Dourados.txt";        
       
        // manipulação de arquivos ============ Escrita======================//        
        try{
            FileOutputStream saida = new FileOutputStream(new File(nomeArquivo));
            byte[] b = menu.toString().getBytes();
            saida.write(b);
        } catch (Exception e){
                        System.err.printf("Ocorreu um erro ao abrir o arqquivo %s.\n", e.getMessage());
            
            
        }
        
         // manipulação de arquivos ============ Leitura ======================//   
         
                 
         // Printando conteúdo do arquivo
         System.out.println("\nLeitura Relatório Poneis Dourados: ");
         try{
             FileReader arquivo = new FileReader(nomeArquivo);
             BufferedReader arqLeitura = new BufferedReader(arquivo);
             String  linha = arqLeitura.readLine();;
             
             // lendo a linha
             while(linha != null){
                 linha = arqLeitura.readLine();
             }
             System.out.println(linha);
             
             arquivo.close();
         }catch (IOException e) {
            //Exception if the file could not be opened
            
            System.err.printf("Ocorreu um erro ao abrir o arquivo %s.\n", e.getMessage());
            
        }
        
         
         
        
        

    }
}

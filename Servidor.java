package servidor;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Servidor {

    public static void main(String[] args) throws IOException {
     //throws UnknownHostException, IOException {
     // dispara cliente
     new Cliente("143.107.231.103", 12347).executa();
   }
   
   private String host;
   private int porta;
   
   public Servidor (String host, int porta) {
     this.host = host;
     this.porta = porta;
   }
   
   public void executa() throws UnknownHostException, IOException {
     Socket cliente = new Socket(this.host, this.porta);
     System.out.println("O cliente se conectou ao servidor!");
 
     // thread para receber mensagens do servidor
     Recebedor r = new Recebedor(cliente.getInputStream());
     new Thread(r).start();
     
     // lê msgs do teclado e manda pro servidor
     Scanner teclado = new Scanner(System.in);
     PrintStream saida = new PrintStream(cliente.getOutputStream());
     while (teclado.hasNextLine()) {
       saida.println(teclado.nextLine());
     }
     
     saida.close();
     teclado.close();
     cliente.close();    
   }

}

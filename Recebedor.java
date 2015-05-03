import java.util.Scanner;
import java.lang.Runnable;
import java.io.InputStream;


 public class Recebedor implements Runnable {
 
   private InputStream servidor;
 
   public Recebedor(InputStream servidor) {
     this.servidor = servidor;
   }
 
   public void run() {
     // recebe msgs do servidor e imprime na tela
     Scanner s = new Scanner(this.servidor);
     while (s.hasNextLine()) {
       System.out.println(s.nextLine());
     }
   }
 }
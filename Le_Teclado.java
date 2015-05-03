
package servidor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Le_Teclado implements Runnable{
   
    public PrintStream saida;
    public OutputStream o;
    public Socket cl;
    
        
    public Le_Teclado (OutputStream out) {
        o = out;
    }
    
    public void run ()
    {
         InputStreamReader inputStr = new InputStreamReader(System.in);
         BufferedReader buf = new BufferedReader(inputStr);
         String str;
         PrintWriter pr = new PrintWriter(o, true);
        try {
            while ((str = buf.readLine().toString()) != null) {
               pr.println(str);
            }
        } catch (IOException ex) {
            Logger.getLogger(Le_Teclado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
}

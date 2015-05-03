
package servidor;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class Le_Servidor implements Runnable{
    
    public InputStream entrada;
    
    public Le_Servidor (InputStream ent) {
       entrada = ent;
    }
    
    
    public void run () {
       
        System.out.println(entrada);
        
    }
}

package chatjava;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class comm {
	public static void main(String trav[]) throws java.io.IOException{

		Socket s = new Socket("143.107.231.103", 12345);

		OutputStream out = s.getOutputStream();
		PrintWriter msg = new PrintWriter(out, true);

		//msg.println("Teste42");
		//.println("WOW!");

		s.close();
	}
}

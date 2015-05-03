package chatjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReceiveMove implements Runnable{

	public Server s;
	public int player;
	public Scanner scan;
	public PrintWriter pw;

	public ReceiveMove(Server s, int player)throws IOException{
		this.s = s;
		this.player = player;
		switch (player){
			case 1:
				this.scan = s.scan1;
				this.pw = s.pw1;
				break;
			case 2:
				this.scan = s.scan2;
				this.pw = s.pw2;
				break;
			default:
				break;
		}
	}

	@Override
	public void run() {

		String input;
		while (scan.hasNextLine()) {
			input = scan.nextLine();
			pw.println(input);
			System.out.println("Player " + player + " : " + input);
		}

		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
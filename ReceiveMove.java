package chatjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ReceiveMove implements Runnable{

	public Server s;
	public int player;

	public ReceiveMove(Server s, int player)throws IOException{
		this.s = s;
		this.player = player;
	}

	@Override
	public void run() {

		String input;
		while (s.scan[player].hasNextLine()) {
			input = s.scan[player].nextLine();
			s.pw[player].println(input);
			System.out.println("Player " + player + " : " + input);
		}

		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
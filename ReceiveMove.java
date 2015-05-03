package chatjava;

import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class ReceiveMove implements Runnable{

	public Server s;
	public int player;
	public InputStream is;

	public ReceiveMove(Server s, int player)throws IOException{
		this.s = s;
		this.player = player;
		switch (player){
			case 1:
				this.is = this.s.player1.getInputStream();
				break;
			case 2:
				this.is = this.s.player2.getInputStream();
				break;
			default:
				break;
		}

	}

	@Override
	public void run() {

		Scanner scan = new Scanner(is);
		String input;
		while (true) {
			System.out.println("While...");
			input = scan.nextLine();
			System.out.println(input);
		}

		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
package chatjava;

public class ReceiveMove implements Runnable{

	public Server s;
	public int player;

	public ReceiveMove(Server s, int player){
		this.s = s;
		this.player = player;
	}

	@Override
	public void run() {

		String input;
		while (s.scan[player].hasNextLine()) {	// Enquanto houver próxima linha...
			input = s.scan[player].nextLine();	// ... Ler a linha...
			System.out.println("> Input Player  " + player + " : \"" + input + "\"");
			s.sendMsg((1-player), input);		// ... e repassá-la para o outro player
		}

		System.out.println("Player " + player + " saiu.");
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
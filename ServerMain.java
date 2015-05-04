package chatjava;

import java.io.IOException;

public class ServerMain {
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.startServer(12345);

		//server.sendAll("ready");

		ReceiveMove rm1 = new ReceiveMove(server, 0);
		ReceiveMove rm2 = new ReceiveMove(server, 1);

		Thread tr_p1 = new Thread(rm1);
		Thread tr_p2 = new Thread(rm2);

		tr_p1.start();
		tr_p2.start();

		//server.closeServer();
	}
}

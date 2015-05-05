package chatjava;

import java.io.IOException;

public class ServerMain {
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.startServer(12345);	// Porta padrão

		// Depois que os clientes conectarem, envia "ready" para os jogadores
		server.sendAll("ready");

		// Cria as classes Runnable
		ReceiveMove rm1 = new ReceiveMove(server, 0);
		ReceiveMove rm2 = new ReceiveMove(server, 1);

		// Cria as threads que farão a comunicação dos clientes
		Thread tr_p1 = new Thread(rm1);
		Thread tr_p2 = new Thread(rm2);

		// Inicia as threads
		tr_p1.start();
		tr_p2.start();

		// Aguarda as threads terminarem
		try {
			tr_p1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			tr_p2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Fecha o ServerSocket
		server.closeServer();
	}
}

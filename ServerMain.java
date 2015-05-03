package chatjava;

import java.io.IOException;

/**
 * Created by CarlosAlberto on 03/05/2015.
 */
public class ServerMain {
	public static void main(String[] args) throws IOException {
		Server server = new Server();
		server.startServer(12345);

		server.sendAll("oi");

		server.closeServer();
	}
}

package chatjava;

import java.io.IOException;

/**
 * Created by CarlosAlberto on 03/05/2015.
 */
public class chat {
	public static void main(String[] args) throws IOException {
		window w = new window();
		comm chat = new comm();
		chat.setIP("172.26.236.219");
		chat.startComm();
		chat.send("Oi :D");
		chat.closeComm();
	}

}

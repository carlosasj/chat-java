package chatjava;

import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class comm {
	public String[] ip;
	public int port;
	private Socket s = null;
	private PrintWriter msg = null;

	public comm() {
		port = 12345;
	}

	public void startComm() throws java.io.IOException{
		this.s = new Socket(this.ip, this.port);
		PrintWriter msg = new PrintWriter(s.getOutputStream(), true);
	}

	public void closeComm() throws java.io.IOException{
		this.s.close();
	}

	public void setIP(String[] ip){
		this.ip = ip;
	}

	public void send(String[] str) throws java.io.IOException {
		msg.println(str);
	}
}

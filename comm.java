package chatjava;

import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class comm {
	public String ip;
	public int port;
	private Socket s = null;
	private PrintWriter msg = null;
	private Scanner scan = null;

	public comm() {
		port = 12345;
	}

	public void startComm() throws java.io.IOException{
		this.s = new Socket(this.ip, this.port);
		this.msg = new PrintWriter(s.getOutputStream(), true);
		this.scan = new Scanner(this.s.getInputStream());
	}

	public void closeComm() throws java.io.IOException{
		this.s.close();
	}

	public void setIP(String ip){
		this.ip = ip;
	}

	public void send(String str) throws java.io.IOException {
		System.out.println(str);
		msg.println(str);
	}
}

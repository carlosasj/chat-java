package chatjava;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private ServerSocket ss = null;
	public Socket[] player;
	public Scanner[] scan;
	public PrintWriter[] pw;



	void startServer(int port) throws IOException{
		this.ss = new ServerSocket(port);

		player = new Socket[2];
		scan = new Scanner[2];
		pw = new PrintWriter[2];

		System.out.println("Porta " + port + " aberta!");

		for (int i = 0; i < 2; i++){
			this.player[i] = WaitPlayer();
			this.scan[i] = new Scanner(this.player[i].getInputStream());
			this.pw[i] = new PrintWriter(this.player[i].getOutputStream(), true);
		}



	}

	void closeServer() throws IOException{
		this.pw1.close();
		this.pw2.close();
		this.scan1.close();
		this.scan2.close();
		this.ss.close();
		this.player[0].close();
		this.player[1].close();
	}

	private Socket WaitPlayer()throws IOException{
		Socket player = ss.accept();
		System.out.println("Novo player: " + player.getInetAddress().getHostAddress());
		return player;
	}

	void sendMsg(int player, String msg){
		switch (player){
			case 1:
				this.pw1.println(msg);
				break;
			case 2:
				this.pw2.println(msg);
				break;
			default:
				break;
		}
	}

	void sendAll(String str){
		this.pw1.println(str);
		this.pw2.println(str);
	}
}
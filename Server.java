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
		for (int i = 0; i < 2; i++){
			pw[i].close();
			scan[i].close();
			player[i].close();
		}
		ss.close();
	}

	private Socket WaitPlayer()throws IOException{
		Socket player = ss.accept();
		System.out.println("Novo player: " + player.getInetAddress().getHostAddress());
		return player;
	}

	void sendMsg(int player, String msg){
		pw[player].println(msg);
	}

	void sendAll(String str){
		sendMsg(0, str);
		sendMsg(1, str);
	}
}
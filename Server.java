package chatjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	private ServerSocket ss = null;
	private Socket player1, player2;
	private Scanner scan1, scan2;
	private PrintWriter pw1, pw2;


	void startServer(int port) throws IOException{
		this.ss = new ServerSocket(port);
		System.out.println("Porta " + port + " aberta!");

		this.player1 = WaitPlayer();
		this.pw1.println("Conectado 1");
		this.player2 = WaitPlayer();
		this.pw1.println("Conectado 2");

		this.scan1 = new Scanner(this.player1.getInputStream());
		this.scan2 = new Scanner(this.player2.getInputStream());

		this.pw1 = new PrintWriter(this.player1.getOutputStream(), true);
		this.pw2 = new PrintWriter(this.player2.getOutputStream(), true);
	}

	void closeServer() throws IOException{
		this.pw1.close();
		this.pw2.close();
		this.scan1.close();
		this.scan2.close();
		this.ss.close();
		this.player1.close();
		this.player2.close();
	}

	private Socket WaitPlayer()throws IOException{
		Socket player = ss.accept();
		System.out.println("Novo player: " + player.getInetAddress().getHostAddress()
		);
		return player;
	}

	void sendAll(String str){
		this.pw1.println(str);
		this.pw2.println(str);
	}
}
package chatjava;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.*;
import java.util.Enumeration;
import java.util.Scanner;

public class Server {
	private ServerSocket ss = null;
	public Socket[] player;
	public Scanner[] scan;
	public PrintWriter[] pw;

	void startServer(int port) throws IOException{
		this.ss = new ServerSocket(port);

		// Exibe todos os IP's da máquina.
		System.out.println("May the 4th be with you.\n\nSeus possiveis IP's:");
		Enumeration e = NetworkInterface.getNetworkInterfaces();
		while(e.hasMoreElements())
		{
			NetworkInterface n = (NetworkInterface) e.nextElement();
			Enumeration ee = n.getInetAddresses();
			while (ee.hasMoreElements())
			{
				InetAddress i = (InetAddress) ee.nextElement();
				System.out.println("\t> " +i.getHostAddress());
			}
		}
		System.out.println("* Provavel IP: " + Inet4Address.getLocalHost());
		// O trecho de código acima não influencia no jogo


		// Cria os Sockets, Scanners e PrintWriters
		player = new Socket[2];
		scan = new Scanner[2];
		pw = new PrintWriter[2];

		System.out.println("* Porta " + port + " aberta!\n");

		// Inicializa os Sockets, Scanners e PrintWriters
		for (int i = 0; i < 2; i++){
			this.player[i] = WaitPlayer();
			this.scan[i] = new Scanner(this.player[i].getInputStream());
			this.pw[i] = new PrintWriter(this.player[i].getOutputStream(), true);
			// Envia para o Jogador se ele é o Player 1 ou o 2
			sendMsg(i, Integer.valueOf(i).toString());
		}



	}

	// Encerra o Server Socket, Scokets, Scanners e PrintWriters
	void closeServer() throws IOException{
		for (int i = 0; i < 2; i++){
			pw[i].close();
			scan[i].close();
			player[i].close();
		}
		ss.close();
	}

	// Aguarda a chegada de um novo Player
	private Socket WaitPlayer()throws IOException{
		Socket player = ss.accept();
		System.out.println("+ Novo player: " + player.getInetAddress().getHostAddress());
		return player;
	}

	// Envia uma mensagem para um player
	void sendMsg(int player, String msg){
		System.out.println("\tSend Player " + player + " : \"" + msg +"\"\n");
		pw[player].println(msg);
	}

	// Envia uma mensagem para todos os players
	void sendAll(String str){
		sendMsg(0, str);
		sendMsg(1, str);
	}
}
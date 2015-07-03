package net.server;

import java.net.Socket;

public class Client extends Thread implements Runnable{

	Socket socket;
	
	public Client(Socket sock){
		this.socket = sock;
		this.start();
	}
	
	@Override
	public void run(){
		
		while(socket.isConnected()){
			
			
			
		}
		
		System.out.println("Client left!" + this.socket.getInetAddress());
		
	}
	
}

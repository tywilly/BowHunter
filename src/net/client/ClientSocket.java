package net.client;

import java.io.IOException;
import java.net.Socket;

public class ClientSocket extends Thread implements Runnable{

	Socket socket;
	
	public ClientSocket(){
		try {
			socket = new Socket("127.0.0.1", 2554);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run(){
		while(!socket.isClosed()){
			
			
			
		}
	}
	
}

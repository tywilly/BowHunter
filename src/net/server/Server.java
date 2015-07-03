package net.server;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;

public class Server extends java.net.ServerSocket{

	public static final int PORT = 2554;
	
	ArrayList<Client> clients = new ArrayList<Client>();
	
	public Server() throws IOException {
		super(PORT);
		
		update();
		
	}

	public void update(){
		
		System.out.println("Listening for connections!");
		
		while(!this.isClosed()){
			
			try {
				Socket sock = this.accept();
				
				clients.add(new Client(sock));
				
				System.out.println("New connection!");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
}

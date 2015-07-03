import java.io.IOException;

import net.server.Server;


public class ServerDriver {
	
	Server server;
	
	public ServerDriver() {
		
		try {
			System.out.println("Starting Server...");
			server = new Server();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args){
		
		ServerDriver driver = new ServerDriver();
		
	}
	
}

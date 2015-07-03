import net.client.ClientSocket;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.scene.SceneManager;


public class ClientDriver {

	ClientSocket client;
	
	Engine engine;
	
	public ClientDriver(){
		
		engine = new Engine(Display.createDisplay(1280, 720));
		engine.start();
		
		SceneManager.loadScene(new GameScene());
		
		client = new ClientSocket();
		client.start();
		
	}
	
	public static void main(String[] args){
		ClientDriver clientD = new ClientDriver();
	}
	
}
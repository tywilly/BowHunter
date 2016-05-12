package apcs;

import net.client.ClientSocket;
import net.client.update.UpdateFetcher;
import apcs.scenes.GameScene;

import java.io.IOException;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.scene.SceneManager;

public class ClientDriver {

	public static final String HOST_NAME = "127.0.0.1";
	
	public static ClientSocket client;

	Engine engine;

	public ClientDriver() {
		
		engine = new Engine(Display.createDisplay(1280,720));
		
		engine.display.setTitle("BowHunter");
		
		engine.start();

		SceneManager.loadScene(new GameScene());

		client = new ClientSocket();
		client.run();

	}

	public static void main(String[] args) {
		LoginForm form = new LoginForm();
	}

}

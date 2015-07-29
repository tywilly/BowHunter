package apcs;

import net.client.ClientSocket;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.scene.SceneManager;

public class ClientDriver {

	public static ClientSocket client;

	Engine engine;

	public ClientDriver() {

		engine = new Engine(Display.createDisplay(1280,720, "BowHunter"));
		engine.start();

		SceneManager.loadScene(new GameScene());

		client = new ClientSocket();
		client.run();

	}

	public static void main(String[] args) {
		LoginForm form = new LoginForm();
	}

}

package apcs.scenes;

import apcs.entitys.Player;
import apcs.entitys.world.Grass;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.scene.Scene;

public class GameScene extends Scene {

	Player spriteTest = new Player(Engine.display.getWidth() / 2,
			Engine.display.getHeight() / 4);

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

		// World loading

		for (int i = 0; i < Engine.display.getWidth(); i += 64) {

			for (int x = 0; x < Engine.display.getHeight(); x += 64) {
				this.addEntity(new Grass(i, x));
			}

		}

		this.addEntity(spriteTest);

	}

}

package apcs.scenes;

import apcs.entitys.player.Player;
import apcs.entitys.world.World;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.DebugInfo;
import com.tywilly.WillyEngine.scene.Scene;

public class GameScene extends Scene {

	public static Player player = new Player(Engine.display.getWidth() / 2,
			Engine.display.getHeight() / 4);
	
	public static World world;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		world = new World();
		
		world.loadWorld("assets/world/default.world");

		world.addToScene();
		
		this.addEntity(player);
		
		this.addEntity(new DebugInfo());
		this.addEntity(player.healthText);

	}
	
}

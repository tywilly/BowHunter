package apcs.scenes;

import game.RoundManager;
import game.ScoreManager;
import apcs.entitys.player.Player;
import apcs.entitys.text.ScoreText;
import apcs.entitys.world.World;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.DebugInfo;
import com.tywilly.WillyEngine.scene.Scene;

public class GameScene extends Scene {

	public static Player player = new Player(Engine.display.getWidth() / 2,
			Engine.display.getHeight() / 4);
	
	public static World world;
	
	public static RoundManager roundManager;
	public static ScoreManager scoreManager;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
	    roundManager = new RoundManager();
	    scoreManager = new ScoreManager();
	    
		world = new World();
		
		world.loadWorld("assets/world/default.world");

		world.addToScene();
		
		this.addEntity(player);
		
		this.addEntity(new DebugInfo());
		
		this.addEntity(new ScoreText());

	}
	
}

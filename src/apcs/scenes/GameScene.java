package apcs.scenes;

import apcs.entitys.Arrow;
import apcs.entitys.SpriteTest;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.scene.Scene;

public class GameScene extends Scene{

	Arrow arrow = new Arrow(0, Engine.display.getHeight()/2);
	SpriteTest spriteTest = new SpriteTest(Engine.display.getWidth()/2, Engine.display.getHeight()/4);
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		//this.addEntity(arrow);
		this.addEntity(spriteTest);
		
	}

}

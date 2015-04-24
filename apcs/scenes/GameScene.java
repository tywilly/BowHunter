package apcs.scenes;

import apcs.entitys.Arrow;

import com.tywilly.WillyEngine.display.Display;
import com.tywilly.WillyEngine.scene.Scene;

public class GameScene extends Scene{

	Arrow arrow = new Arrow(Display.SCREEN_WIDTH, Display.SCREEN_HEIGHT/2);
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		this.addEntity(arrow);
		//this.addEntity(new Arrow(Display.SCREEN_WIDTH, Display.SCREEN_HEIGHT/3));
		
	}

}

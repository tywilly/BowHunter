package apcs.scenes;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.scene.Scene;

public class EndScene extends Scene{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		this.addEntity(new Text(Engine.display.getWidth()/2, Engine.display.getHeight()/2, 24, "Game Over"));
		
	}

}

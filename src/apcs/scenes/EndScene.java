package apcs.scenes;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.Scene;
import com.tywilly.WillyEngine.scene.SceneManager;

public class EndScene extends Scene{

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		
		this.addEntity(new Text((Engine.display.getWidth()/2) - 50, (Engine.display.getHeight()/2) - 25, 24, "Game Over"));
		
		this.addEntity(new Text((Engine.display.getWidth()/2) - 95, (Engine.display.getHeight()/2), 20, "Press space to restart!"));
	
		this.addEntity(new RestartButton());
		
	}

	public class RestartButton extends Entity implements Input{

		public RestartButton() {
			super(0, 0, 1, 1);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onInput(InputAction e) {
			// TODO Auto-generated method stub
			
			if(e.getAction() == ActionType.KEYBOARD_UP){
				if(e.getKeyCode() == ' '){
					SceneManager.loadScene(new GameScene());
				}
			}
			
		}
		
		
		
	}
	
}

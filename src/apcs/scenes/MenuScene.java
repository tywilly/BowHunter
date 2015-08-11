package apcs.scenes;

import apcs.entitys.ui.Button;
import apcs.entitys.ui.Button.OnClickAction;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.scene.Scene;
import com.tywilly.WillyEngine.scene.SceneManager;

public class MenuScene extends Scene {

	Scene previousScene;

	Button returnBtn;

	public MenuScene(Scene prevScene) {
		this.previousScene = prevScene;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

		if (previousScene != null) {

			returnBtn = new Button(Engine.display.getWidth() / 2,
					Engine.display.getHeight() / 2, 4, 200, 75);

			returnBtn.setOnClickAction(new OnClickAction() {
				@Override
				public void onClick() {
					// TODO Auto-generated method stub
					SceneManager.loadScene(previousScene);
				}
			});

			this.addEntity(returnBtn);
			
		}

	}

}

package apcs.scenes;

import apcs.ClientDriver;
import apcs.entitys.ui.Button;
import apcs.entitys.ui.Button.OnClickAction;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.scene.Scene;
import com.tywilly.WillyEngine.scene.SceneManager;

public class MenuScene extends Scene {

	Scene previousScene;

	Button returnBtn;
	Button quitBtn;

	public MenuScene(Scene prevScene) {
		this.previousScene = prevScene;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub

		returnBtn = new Button(Engine.display.getWidth() / 2 - 100, Engine.display.getHeight() / 2 - 50, 4, 200, 75);

		returnBtn.setOnClickAction(new OnClickAction() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				SceneManager.swapScene(previousScene);
			}
		});

		quitBtn = new Button(Engine.display.getWidth()/2 - 100, Engine.display.getHeight() /2 + 100, 4, 200, 75);
		
		quitBtn.setOnClickAction(new OnClickAction() {
			@Override
			public void onClick() {
				// TODO Auto-generated method stub
				ClientDriver.client.disconnect();
			}
		});
		
		
		this.addEntity(returnBtn);
		this.addEntity(quitBtn);

	}

}

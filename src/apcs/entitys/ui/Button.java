package apcs.entitys.ui;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;

public class Button extends Sprite implements Input {

	OnClickAction action;

	boolean isDown = false;
	
	Texture downText = TextureManager.createTexture("assets/ui/button/button_down.png");
	Texture upText = TextureManager.createTexture("assets/ui/button/button_up.png");
	
	public Button(float x, float y, int layer, int width, int height) {
		super(x, y, layer, width, height, null);
		
		if(!downText.isLoaded() || !upText.isLoaded()){
			downText.loadIntoMemery();
			upText.loadIntoMemery();
		}
		
		this.setTexure(upText);
		
	}

	public void setOnClickAction(OnClickAction action) {
		this.action = action;
	}

	@Override
	public void onInput(InputAction e) {
		// TODO Auto-generated method stub

		if ((e.getMouseX() >= this.getX() && e.getMouseX() <= this.getX()
				+ this.getWidth())
				&& (e.getMouseY() >= this.getY() && e.getMouseY() <= this
						.getY() + this.getHeight())) {

			if (e.getAction() == ActionType.MOUSE_DOWN) {
				isDown = true;
				this.setTexure(downText);
			} else if (e.getAction() == ActionType.MOUSE_UP) {
				if (isDown) {
					action.onClick();
				}
				isDown = false;
				this.setTexure(upText);
			}

		}

	}

	public interface OnClickAction {
		public void onClick();
	}

}

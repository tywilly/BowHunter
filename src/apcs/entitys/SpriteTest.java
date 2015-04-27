package apcs.entitys;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class SpriteTest extends Sprite implements Updateable, Input {

	Texture rightTexture;
	Texture leftTexture = new Texture("assets/obama_sprite_left.png");
	
	public SpriteTest(int x, int y) {
		super(x, y, 64, 64, new Texture("assets/obama_sprite_right.png"));
		this.getTexture().loadIntoMemery();
		rightTexture = this.getTexture();
		leftTexture.loadIntoMemery();
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
	}

	@Override
	public void onInput(InputAction e) {
		// TODO Auto-generated method stub
		
		if(e.getAction() == ActionType.KEYBOARD_DOWN){
			if(e.getKeyCode() == 'd'){
				this.setTexure(rightTexture);
				xLoc += 4;
			}else if(e.getKeyCode() == 'a'){
				this.setTexure(leftTexture);
				xLoc -= 4;
			}else if(e.getKeyCode() == 'w'){
				yLoc -= 4;
			}else if(e.getKeyCode() == 's'){
				yLoc += 4;
			}
		}else if(e.getAction() == ActionType.MOUSE_DOWN){
			if(e.getKeyCode() == '1'){
				xLoc += 2;
			}else if(e.getKeyCode() == '2'){
				xLoc -= 2;
			}
		}
		
	}

}

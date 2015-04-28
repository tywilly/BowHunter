package apcs.entitys;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.input.Input;
import com.tywilly.WillyEngine.input.InputAction;
import com.tywilly.WillyEngine.input.InputAction.ActionType;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class Player extends Sprite implements Updateable, Input {
	
	String playerName = "Player 1";

	Texture rightTexture;
	Texture leftTexture = new Texture("assets/characters/obama_sprite_left.png");
	
	boolean right = false;
	boolean left = false;
	boolean up = false;
	boolean down = false;
	
	public Player(int x, int y) {
		super(x, y, 64, 64, new Texture("assets/characters/obama_sprite_right.png"));
		this.getTexture().loadIntoMemery();
		rightTexture = this.getTexture();
		leftTexture.loadIntoMemery();
	}

	
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 20));
		g.drawString(playerName, xLoc - 2, yLoc - 10);
		
	}



	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		if(up){
			yLoc -= 0.5 * mili;
		}else if(down){
			yLoc += 0.5 * mili;
		}
		
		if(right){
			xLoc += 0.5 * mili;
		}else if(left){
			xLoc -= 0.5 * mili;
		}
		
	}

	@Override
	public void onInput(InputAction e) {
		// TODO Auto-generated method stub
		
		if(e.getAction() == ActionType.KEYBOARD_DOWN){
			if(e.getKeyCode() == 'd'){
				this.setTexure(rightTexture);
				right = true;
			}else if(e.getKeyCode() == 'a'){
				this.setTexure(leftTexture);
				left = true;
			}else if(e.getKeyCode() == 'w'){
				up = true;
			}else if(e.getKeyCode() == 's'){
				down = true;
			}else if(e.getKeyCode() == ' '){

			}
		}else if(e.getAction() == ActionType.KEYBOARD_UP){
			
			if(e.getKeyCode() == 'd'){
				right = false;
			}else if(e.getKeyCode() == 'a'){
				left = false;
			}else if(e.getKeyCode() == 'w'){
				up = false;
			}else if(e.getKeyCode() == 's'){
				down = false;
			}
			
		}else if(e.getAction() == ActionType.MOUSE_DOWN){
			if(e.getKeyCode() == '1'){
				if(this.getTexture() == leftTexture){
					SceneManager.getCurrentScene().addEntity(new Arrow(xLoc - this.width/2, (yLoc + this.height/2) - 16, 4));
				}else if(this.getTexture() == rightTexture){
					SceneManager.getCurrentScene().addEntity(new Arrow(xLoc + this.width, (yLoc + this.height/2) - 16 , 2));
				}
			}
		}
		
	}

}

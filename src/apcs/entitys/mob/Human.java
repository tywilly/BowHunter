package apcs.entitys.mob;

import apcs.entitys.player.Player;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;

public class Human extends Mob{
	
	Texture left = this.getTexture();
	Texture right = TextureManager.createTexture("assets/characters/obama_sprite_left.png");
	
	public Human(int x, int y) {
		super(x, y, 64, 64, TextureManager.createTexture("assets/characters/obama_sprite_left.png"));
		// TODO Auto-generated constructor stub
		
		if(!left.isLoaded() || !right.isLoaded()){
			left.loadIntoMemery();
			right.loadIntoMemery();
		}
		
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		Player p = ((GameScene) SceneManager.getCurrentScene()).getPlayer();
		
		if(this.getX() > p.getX()){
			xLoc -= (0.25 * mili);
		}else if(this.getX() < p.getX()){
			xLoc += (0.25 * mili);
		}
		
		if(this.getY() > p.getY()){
			yLoc -= 0.25 * mili;
		}else if(this.getY() < p.getY()){
			yLoc += (0.25 * mili);
		}
		
	}

}

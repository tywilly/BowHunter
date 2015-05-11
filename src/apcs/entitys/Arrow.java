package apcs.entitys;

import com.tywilly.WillyEngine.Engine; 
import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class Arrow extends Sprite implements Updateable{

	int dir = 0;
	
	static Texture leftTexture = new Texture("assets/weapons/bullets/new/arrow_left.png");
	static Texture rightTexture = new Texture("assets/weapons/bullets/new/arrow_right.png");
	
	public Arrow(int x, int y, int dir) {
		super(x, y, 64, 32, null);
		// TODO Auto-generated constructor stub
		
		
		if(!leftTexture.isLoaded()){
			leftTexture.loadIntoMemery();
		}
		if(!rightTexture.isLoaded()){
			rightTexture.loadIntoMemery();
		}
		
		this.dir = dir;
		
		if(this.dir == 2){
			this.setTexure(rightTexture);
		}else if(this.dir == 4){
			this.setTexure(leftTexture);
		}
		
		
	}
	
	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		if(xLoc >= Engine.display.getWidth() || xLoc <= 0){
			SceneManager.getCurrentScene().removeEntity(this);
		}
		
		if(dir == 2){
			xLoc += (int) (1 * mili);
		}else if(dir == 4){
			xLoc -= (int) (1 * mili);
		}
		
		
		
	}
	
}

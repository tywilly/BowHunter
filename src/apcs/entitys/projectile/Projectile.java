package apcs.entitys.projectile;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class Projectile extends Sprite implements Updateable{

	int xDir = 0;
	int yDir = 0;
	
	public Projectile(int x, int y, int height, int width , int xDir, int yDir, Texture texture) {
		super(x, y, height, width, texture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		xLoc += xDir;
		yLoc += yDir;
		
	}

	
	
}

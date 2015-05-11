package apcs.entitys.projectile;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class Projectile extends Sprite implements Updateable{

	float xDir = 0;
	float yDir = 0;
	
	public Projectile(int x, int y, int height, int width , float xDir, float yDir, Texture texture) {
		super(x, y, height, width, texture);
		// TODO Auto-generated constructor stub
		this.xDir = xDir;
		this.yDir = yDir;
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
	    if (xLoc >= Engine.display.getWidth() || xLoc <= 0)
        {
            SceneManager.getCurrentScene().removeEntity(this);
        }
	    
		xLoc += xDir * mili;
		yLoc += yDir * mili;
		
	}

	
	
}

package apcs.entitys.mob;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public abstract class Mob extends Sprite implements Updateable{
	
	public Mob(int x, int y, int height, int width, Texture texture) {
		super(x, y, height, width, texture);
		// TODO Auto-generated constructor stub
	}
	
}

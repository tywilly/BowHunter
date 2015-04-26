package apcs.entitys;

import com.tywilly.WillyEngine.Engine;
import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.update.Updateable;

public class SpriteTest extends Sprite implements Updateable{

	public SpriteTest(int x, int y) {
		super(x, y, 64,64, new Texture("assets/obama_sprite_left.png"));
		this.getTexture().loadIntoMemery();
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
		if(xLoc >= Engine.display.getWidth()){
			xLoc = 0;
		}
		
		xLoc += 1;
		
	}

}

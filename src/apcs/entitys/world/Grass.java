package apcs.entitys.world;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;
import com.tywilly.WillyEngine.update.Updateable;

public class Grass extends Sprite implements Updateable{

	Texture textre = TextureManager.createTexture("assets/world/ground/grass.png");
	
	public Grass(int x, int y) {
		super(x, y, 64, 64, null);
		// TODO Auto-generated constructor stub
		
		this.setTexure(textre);
		this.textre.loadIntoMemery();
	}

	@Override
	public void update(long mili) {
		// TODO Auto-generated method stub
		
//		this.xLoc += GameScene.world.getXLocation();
//		this.yLoc += GameScene.world.getYLocation();
	}
}

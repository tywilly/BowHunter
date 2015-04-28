package apcs.entitys.world;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;

public class Grass extends Sprite{

	Texture textre = new Texture("assets/world/grass.png");
	
	public Grass(int x, int y) {
		super(x, y, 64, 64, null);
		// TODO Auto-generated constructor stub
		
		this.setTexure(textre);
		this.textre.loadIntoMemery();
	}
}

package apcs.entitys.world;

import java.awt.Graphics;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;

public class Grass extends Sprite {

	Texture textre = TextureManager
			.createTexture("assets/world/ground/grass.png");

	public Grass(int x, int y) {
		super(x, y, 0, 64, 64, null);
		// TODO Auto-generated constructor stub

		this.setTexure(textre);
		this.textre.loadIntoMemery();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub

		g.drawImage(this.getTexture().getImage(),
				(int) (this.getX() + World.xLoc),
				(int) (this.getY() + World.yLoc),
				(int) (this.getX() + World.xLoc) + this.width,
				(int) (this.getY() + World.yLoc) + this.height, 0, 0, this
						.getTexture().getImage().getWidth(), this.getTexture()
						.getImage().getHeight(), null);

	}

}

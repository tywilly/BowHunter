package apcs.entitys;

import apcs.entitys.world.World;

import com.tywilly.WillyEngine.entity.sprite.Sprite;
import com.tywilly.WillyEngine.texture.Texture;

public class WorldEntity extends Sprite {

	private String UUID = "";

	public WorldEntity(float x, float y, int height, int width, Texture texture) {
		super(x, y, height, width, texture);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void paint() {
		// TODO Auto-generated method stub

//		g.drawImage(this.getTexture().getImage(),
//				(int) (this.getX() + World.xLoc),
//				(int) (this.getY() + World.yLoc),
//				((int) (this.getX() + World.xLoc)) + this.width,
//				((int) (this.getY() + World.yLoc)) + this.height, 0, 0, this
//						.getTexture().getImage().getWidth(), this.getTexture()
//						.getImage().getHeight(), null);
		

	}

	public void setWorldX(float x) {
		//this.xLoc = x + World.xLoc;
		this.xLoc = x;
		//System.out.println("WorldX: "+ World.xLoc + " PlayerX:" + this.xLoc + " Total: " + x);
	}

	public float getWorldX() {
		return this.xLoc + (-World.xLoc);
	}

	public void setWorldY(float y) {
		this.yLoc = y;
	}

	public float getWorldY() {
		return this.yLoc + (-World.yLoc);
	}

	public String getUUID() {
		return UUID;
	}

	public void setUUID(String UUID) {
		this.UUID = UUID;
	}

}

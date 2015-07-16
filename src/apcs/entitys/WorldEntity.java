package apcs.entitys;

import java.awt.Graphics;

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
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		
		g.drawImage(this.getTexture().getImage(), (int)this.getWorldX(), (int)this.getWorldY(), ((int)this.getWorldX()) + this.width, ((int)this.getWorldY()) + this.height,
                0, 0, this.getTexture().getImage().getWidth(), this.getTexture().getImage().getHeight(), null);
		
	}
	
	public void setWorldX(float x){
		System.out.println("WE SET!");
		this.xLoc = x - (World.xLoc);
	}
	
	public float getWorldX(){
		return (World.xLoc) + this.xLoc;
	}
	
	public void setWorldY(float y){
		this.yLoc = y - (World.yLoc);
	}
	
	public float getWorldY(){
		return (World.yLoc) + this.yLoc;
	}

	public String getUUID(){
		return UUID;
	}
	
	public void setUUID(String UUID){
		this.UUID = UUID;
	}
	
}

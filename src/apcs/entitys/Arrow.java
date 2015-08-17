package apcs.entitys;

import com.tywilly.WillyEngine.texture.TextureManager;

public class Arrow extends WorldEntity{
	
	public Arrow(float x, float y) {
		super(-100, 0, 64, 64, TextureManager.createTexture("assets/weapons/bullets/new/arrow_right.png"));
		
		this.getTexture().loadIntoMemery();
		
		this.setWorldX(x);
		this.setWorldY(y);
	}

}

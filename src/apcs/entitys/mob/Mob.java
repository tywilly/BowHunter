package apcs.entitys.mob;

import com.tywilly.WillyEngine.texture.TextureManager;

import apcs.entitys.WorldEntity;

public class Mob extends WorldEntity{
	
	int mobId = 0;
	
	public Mob(int modId) {
		super(0, 0, 0, 0, null);
		
		this.mobId = modId;
		
		switch (mobId) {
		case 2:
			
			this.setTexure(TextureManager.createTexture("assets/characters/obama_sprite_right.png"));
			
			break;

		default:
			break;
		}
		
		if(!this.getTexture().isLoaded()){
			this.getTexture().loadIntoMemery();
		}
		
		this.setWidth(this.getTexture().getImage().getWidth());
		this.setHeight(this.getTexture().getImage().getHeight());
		
	}
	
}

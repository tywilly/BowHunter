package apcs.entitys.mob;

import com.tywilly.WillyEngine.texture.TextureManager;

import apcs.entitys.WorldEntity;

public class Mob extends WorldEntity{
	
	int mobId = 0;
	
	public Mob(int modId) {
		super(-100, 0, 0, 0, null);
		
		this.mobId = modId;
		
		switch (mobId) {
		case 2:
			
			this.setTexure(TextureManager.createTexture("assets/characters/sarge_right.png"));
			
			this.setWidth(64);
			this.setHeight(64);
			
			break;

		default:
			System.out.println("ERROR: Unknown mob ID!");
			break;
		}
		
		if(!this.getTexture().isLoaded()){
			this.getTexture().loadIntoMemery();
		}
		
	}
	
}

package net.client.protocol.packet;

import com.tywilly.WillyEngine.scene.SceneManager;
import com.tywilly.WillyEngine.texture.Texture;
import com.tywilly.WillyEngine.texture.TextureManager;

import apcs.entitys.Arrow;
import apcs.entitys.WorldEntity;
import apcs.entitys.mob.Mob;


public class SpawnEntityPacket extends Packet{

	public SpawnEntityPacket(){
		super((byte)4, "");
	}
	
	public void oldonRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		String[] pay = payload.split(" ");
		
		switch (Integer.parseInt(pay[1])) {

		case 3:
			//Arrow
			
			Arrow arrow = new Arrow(Float.parseFloat(pay[2]), Float.parseFloat(pay[3]));
			
			arrow.setUUID(pay[0]);
			
			SceneManager.getCurrentScene().addEntity(arrow);
			
			break;

		default:
			
			Mob mob = new Mob(Integer.parseInt(pay[1]));
			
			mob.setUUID(pay[0]);
			
			mob.setX(Float.parseFloat(pay[2]));
			mob.setY(Float.parseFloat(pay[3]));
			
			SceneManager.getCurrentScene().addEntity(mob);
			
			break;
		}
		
	}

	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		String[] pay = payload.split(" ");
		
		Texture texture = TextureManager.createTexture(pay[1]);
		
		if(!texture.isLoaded()){
			texture.loadIntoMemery();
		}
		
		WorldEntity we = new WorldEntity(Float.parseFloat(pay[2]), Float.parseFloat(pay[3]),
				texture.getImage().getHeight(), texture.getImage().getWidth(), texture);
		
		we.setUUID(pay[0]);
		
		SceneManager.getCurrentScene().addEntity(we);
		
		
	}

}

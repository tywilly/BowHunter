package net.client.protocol.packet;

import com.tywilly.WillyEngine.scene.SceneManager;

import apcs.entitys.Arrow;
import apcs.entitys.mob.Mob;


public class SpawnEntityPacket extends Packet{

	public SpawnEntityPacket(){
		super((byte)4, "");
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		System.out.println(payload);
		
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

}

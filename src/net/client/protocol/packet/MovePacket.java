package net.client.protocol.packet;

import apcs.entitys.WorldEntity;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.scene.SceneManager;


public class MovePacket extends Packet{

	public MovePacket(){
		super((byte)03,"");
	}
	
	public MovePacket(String uuid, String location){
		super((byte)03, location);
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		for(int i=0;i<SceneManager.getCurrentScene().ents.size();i++){
			
			Entity ent = SceneManager.getCurrentScene().ents.get(i);
			
			if(ent instanceof WorldEntity){
				
				WorldEntity we = (WorldEntity) ent;
				
				if(we.getUUID().equals(payload.split(" ")[0])){
					we.setWorldX(Float.parseFloat(payload.split(" ")[1]));
					we.setWorldY(Float.parseFloat(payload.split(" ")[2]));
				}
			}
			
		}
		
	}

}

package net.client.protocol.packet;

import apcs.entitys.player.PlayerMP;
import apcs.scenes.GameScene;

import com.tywilly.WillyEngine.scene.SceneManager;

public class LoginPacket extends Packet{

	public LoginPacket(){
	}
	
	public LoginPacket(String username) {
		super((byte)01, username);
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		if(!GameScene.player.playerName.equals(payload.split(" ")[1])){
			
			PlayerMP mp = new PlayerMP(0, 0, payload.split(" ")[1]);
			
			mp.setUUID(payload.split(" ")[0]);
			
			SceneManager.getCurrentScene().addEntity(mp);
		}else{
			GameScene.player.setUUID(payload.split(" ")[0]);
		}
		
	}

}

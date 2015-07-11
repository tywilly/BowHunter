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
		
		if(payload != ((GameScene)SceneManager.getCurrentScene()).player.playerName){
			SceneManager.getCurrentScene().addEntity(new PlayerMP(100, 100, payload));
		}
		
	}

}

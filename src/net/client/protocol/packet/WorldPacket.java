package net.client.protocol.packet;

import apcs.scenes.GameScene;

public class WorldPacket extends Packet {

	public WorldPacket(){
		super((byte)10, "");
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		GameScene.world.interpretWorld(payload);
		
		GameScene.world.addToScene();
		
	}

}

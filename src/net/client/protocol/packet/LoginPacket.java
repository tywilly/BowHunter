package net.client.protocol.packet;

import apcs.scenes.GameScene;


public class LoginPacket extends Packet {

	public LoginPacket() {
	}

	public LoginPacket(String username) {
		super((byte) 01, username);
	}

	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		GameScene.player.setUUID(payload);
	}

}

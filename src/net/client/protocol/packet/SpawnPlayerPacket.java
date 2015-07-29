package net.client.protocol.packet;

import apcs.entitys.player.PlayerMP;

import com.tywilly.WillyEngine.scene.SceneManager;

public class SpawnPlayerPacket extends Packet {

	public SpawnPlayerPacket() {
		super((byte) 07, "");
	}

	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub

		String[] split = payload.split(" ");

		PlayerMP player = new PlayerMP(0, 0, split[1]);

		player.setUUID(split[0]);
		player.setWorldX(Float.parseFloat(split[2]));
		player.setWorldY(Float.parseFloat(split[3]));

		SceneManager.getCurrentScene().addEntity(player);
	}

}

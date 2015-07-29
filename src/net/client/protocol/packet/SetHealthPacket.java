package net.client.protocol.packet;

import apcs.entitys.player.APlayer;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.scene.SceneManager;

public class SetHealthPacket extends Packet {

	public SetHealthPacket() {
		super((byte) 8, "");
	}

	public SetHealthPacket(String UUID, int health) {
		super((byte) 8, UUID + " " + health);
	}

	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub

		for (int i = 0; i < SceneManager.getCurrentScene().ents.size(); i++) {

			Entity ent = SceneManager.getCurrentScene().ents.get(i);

			if (ent instanceof APlayer) {
				APlayer we = (APlayer) ent;

				if (we.getUUID().equals(payload.split(" ")[0])) {
					we.setHealth(Integer.parseInt(payload.split(" ")[1]));
				}

			}

		}

	}

}

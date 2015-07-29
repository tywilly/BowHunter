package net.client.protocol.packet;

import java.util.ArrayList;

import apcs.entitys.WorldEntity;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.scene.SceneManager;

public class MovePacket extends Packet {

	public MovePacket() {
		super((byte) 03, "");
	}

	public MovePacket(String uuid, String location) {
		super((byte) 03, location);
	}

	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub

		for (int i = 0; i < SceneManager.getCurrentScene().getEntitysList()
				.size(); i++) {

			ArrayList<Entity> layer = SceneManager.getCurrentScene()
					.getLayerList(i);

			for (int x = 0; x < layer.size(); x++) {

				Entity ent = layer.get(x);

				if (ent instanceof WorldEntity) {

					WorldEntity we = (WorldEntity) ent;

					if (we.getUUID().equals(payload.split(" ")[0])) {
						we.setWorldX(Float.parseFloat(payload.split(" ")[1]));
						we.setWorldY(Float.parseFloat(payload.split(" ")[2]));
					}
				}

			}

		}

	}

}

package net.client.protocol.packet;

public class ActionPacket extends Packet {

	public ActionPacket(String UUID, String actionId, String rotation){
		super((byte)9, UUID + " " + actionId + " " + rotation);
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
	}

}

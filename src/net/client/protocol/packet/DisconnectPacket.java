package net.client.protocol.packet;

public class DisconnectPacket extends Packet {

	public DisconnectPacket() {
		super((byte)02, "");
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
	}

}

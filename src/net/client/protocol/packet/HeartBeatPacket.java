package net.client.protocol.packet;

import apcs.ClientDriver;

public class HeartBeatPacket extends Packet {

	public HeartBeatPacket(String payload){
		super((byte) 18, payload);
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		ClientDriver.client.sendPacket(new HeartBeatPacket(payload));
	}

}

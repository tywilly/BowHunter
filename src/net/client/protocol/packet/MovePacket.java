package net.client.protocol.packet;


public class MovePacket extends Packet{

	public MovePacket(){
		super((byte)03,"");
	}
	
	public MovePacket(String uuid, String location){
		super((byte)3, location);
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
	}

}

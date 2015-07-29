package net.client.protocol.packet;

import apcs.chat.ChatManager;

public class ChatPacket extends Packet{

	public ChatPacket(){
		super((byte)11,"");
	}
	
	public ChatPacket(String msg){
		super((byte)11, msg);
	}
	
	@Override
	public void onRecieve(byte id, String payload) {
		// TODO Auto-generated method stub
		
		ChatManager.addMessage(payload);
		
	}
	
}

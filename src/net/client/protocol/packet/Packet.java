package net.client.protocol.packet;

public abstract class Packet {

	byte packetId;
	
	String payload = "";
	
	public Packet(){
		
	}
	
	public Packet(byte id, String payload){
		this.packetId = id;
		this.payload = payload;
	}
	
	public abstract void onRecieve(byte id, String payload);
	
	public void setId(byte id){
		this.packetId = id;
	}
	
	public byte getId(){
		return packetId;
	}
	
	public void setPayload(String payload){
		this.payload = payload;
	}
	
	public String getPayload(){
		return payload;
	}
	
	public String getData(){
		return packetId + " " + payload;
	}
	
}

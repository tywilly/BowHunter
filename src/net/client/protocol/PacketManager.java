package net.client.protocol;

import java.util.ArrayList;

import net.client.protocol.packet.LoginPacket;
import net.client.protocol.packet.MovePacket;
import net.client.protocol.packet.Packet;

public class PacketManager {

	Packet[] packets = new Packet[256];
	
	ArrayList<Packet> queue = new ArrayList<Packet>();
	
	public PacketManager(){
		
		packets[1] = new LoginPacket();
		packets[3] = new MovePacket();
		
	}
	
	public Packet getPacketById(byte id){
		return packets[id];
	}
	
	public void addQueue(Packet pack){
		queue.add(pack);
	}
	
	public ArrayList<Packet> getQueue(){
		return queue;
	}
	
}

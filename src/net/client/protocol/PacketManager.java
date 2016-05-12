package net.client.protocol;

import java.util.ArrayList;

import net.client.protocol.packet.ChatPacket;
import net.client.protocol.packet.DespawnEntityPacket;
import net.client.protocol.packet.HeartBeatPacket;
import net.client.protocol.packet.LoginPacket;
import net.client.protocol.packet.MovePacket;
import net.client.protocol.packet.Packet;
import net.client.protocol.packet.SetHealthPacket;
import net.client.protocol.packet.SpawnEntityPacket;
import net.client.protocol.packet.SpawnPlayerPacket;
import net.client.protocol.packet.WorldPacket;

public class PacketManager {

	Packet[] packets = new Packet[256];
	
	ArrayList<Packet> queue = new ArrayList<Packet>();
	
	public PacketManager(){
		
		packets[1] = new LoginPacket();
		packets[3] = new MovePacket();
		
		packets[4] = new SpawnEntityPacket();
		packets[5] = new DespawnEntityPacket();
		
		packets[7] = new SpawnPlayerPacket();
		
		packets[8] = new SetHealthPacket();
		
		packets[10] = new WorldPacket();
		
		packets[11] = new ChatPacket();
		
		packets[18] = new HeartBeatPacket("");
		
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

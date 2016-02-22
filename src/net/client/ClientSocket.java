package net.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import apcs.scenes.GameScene;
import net.client.protocol.PacketManager;
import net.client.protocol.packet.DisconnectPacket;
import net.client.protocol.packet.LoginPacket;
import net.client.protocol.packet.Packet;

public class ClientSocket {

	DatagramSocket socket;

	PacketManager packetMan = new PacketManager();

	byte[] receiveBuffer = new byte[2048];
	byte[] sendBuffer = new byte[1024];

	DatagramPacket recPacket;
	DatagramPacket sendPacket;

	public ClientSocket() {
		try {
			socket = new DatagramSocket();
			socket.connect(InetAddress.getByName("127.0.0.1"), 2554);

			recPacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
			sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// public PacketManager getPacketManager(){
	// return packetMan;
	// }

	public void run() {

		this.sendPacket(new LoginPacket(GameScene.player.playerName));

		Thread inStream = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				while (!socket.isClosed()) {

					String line;

					try {

						socket.receive(recPacket);

						line = new String(recPacket.getData(), 0 , recPacket.getLength());

						byte id = Byte.parseByte(line.substring(0, line.indexOf(" ")));

						String payload = line.substring(line.indexOf(" ") + 1, line.length());

						packetMan.getPacketById(id).onRecieve(id, payload);

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();

						disconnect();

					}

				}

			}
		});

		inStream.start();

	}

	public void sendPacket(Packet pack) {
		try {
			sendPacket.setData(pack.getData().getBytes());
			//sendPacket.setLength(pack.getData().getBytes().length);

			socket.send(sendPacket);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void disconnect() {
		sendPacket(new DisconnectPacket());
		socket.close();
		System.exit(0);
	}

}

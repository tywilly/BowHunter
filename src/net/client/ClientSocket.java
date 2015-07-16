package net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import apcs.scenes.GameScene;
import net.client.protocol.PacketManager;
import net.client.protocol.packet.LoginPacket;
import net.client.protocol.packet.Packet;

public class ClientSocket {

	Socket socket;
	PrintWriter out;
	BufferedReader in;

	PacketManager packetMan;

	public ClientSocket() {
		try {
			socket = new Socket("127.0.0.1", 2554);

			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));

			packetMan = new PacketManager();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public PacketManager getPacketManager(){
		return packetMan;
	}
	
	public void run() {

		this.packetMan.addQueue(new LoginPacket(GameScene.player.playerName));

		Thread inStream = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				while (!socket.isClosed()) {

					String line;

					try {
						line = in.readLine();

						byte id = Byte.parseByte(line.substring(0,
								line.indexOf(" ")));

						String payload = line.substring(line.indexOf(" ")+1,
								line.length());

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

		Thread outStream = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub

				while (!socket.isClosed()) {

					if (!packetMan.getQueue().isEmpty()) {

						for (int i=0;i<packetMan.getQueue().size();i++) {
							
							Packet pack = packetMan.getQueue().get(i);
							
							out.print(pack.getData() + "\r");
							
						}

						out.flush();
						
						packetMan.getQueue().clear();

					}

				}

			}
		});

		outStream.start();

	}
	
	public void disconnect(){
		
		try {
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}

package net.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import net.client.protocol.PacketManager;
import net.client.protocol.packet.DisconnectPacket;
import net.client.protocol.packet.LoginPacket;
import net.client.protocol.packet.Packet;
import apcs.scenes.GameScene;

public class ClientSocket {

	Socket socket;
	PrintWriter out;
	BufferedReader in;

	PacketManager packetMan = new PacketManager();

	public ClientSocket() {
		try {
			socket = new Socket("tywilly.com", 2554);

			out = new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

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
						line = in.readLine();

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
		out.println(pack.getData());
		out.flush();
	}

	public void disconnect() {

		try {

			sendPacket(new DisconnectPacket());

			socket.close();

			System.exit(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

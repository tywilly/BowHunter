package net.client.update;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Scanner;

import apcs.ClientDriver;

public class UpdateFetcher {

	URL updateUrl;
	String host = "http://" + ClientDriver.HOST_NAME + ":8080/";

	public UpdateFetcher() {

	}

	public void fetchUpdates() throws IOException {

		updateUrl = new URL(host + "revision.rev");

		ReadableByteChannel rbc = Channels.newChannel(updateUrl.openStream());
		FileOutputStream out = new FileOutputStream("assets/revision.rev");
		out.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
		out.close();

		Scanner fileScanner = new Scanner(new File("assets/revision.rev"));

		while (fileScanner.hasNextLine()) {

			String line = fileScanner.nextLine();

			if (line.isEmpty()) {
				continue;
			}

			File file = new File("assets/" + line);

			//ystem.out.println(line);

			if (!file.exists()) {

				if (line.lastIndexOf(File.separatorChar) > 0) {
					File fileDir = new File("assets/" + line.substring(0, line.lastIndexOf(File.separatorChar)));
					fileDir.mkdirs();
				}
				file.createNewFile();
				System.out.println("Updater: Fetching " + line);
			} else {
				continue;
			}

			updateUrl = new URL(host + line);
			ReadableByteChannel rbc2 = Channels.newChannel(updateUrl.openStream());
			FileOutputStream out2 = new FileOutputStream(file);
			getClass();
			out2.getChannel().transferFrom(rbc2, 0, Long.MAX_VALUE);
			out2.flush();
			out2.close();

		}

		System.out.println("Updater: Finished updating!");

		fileScanner.close();

	}

}

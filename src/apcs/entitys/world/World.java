package apcs.entitys.world;

import java.util.ArrayList;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.scene.SceneManager;

public class World {

	private int width = 0;
	private int height = 0;

	public static float xLoc = 0;
	public static float yLoc = 0;

	private ArrayList<Entity> world = new ArrayList<Entity>();

	public void interpretWorld(String worldData) {

		String[] lines = worldData.split(":");

		Entity worldTile = null;

		for (int x=0;x<lines.length;x++) {

			for (int i = 0; i < lines[x].length(); i++) {
				if (lines[x].charAt(i) == '1') {
					worldTile = new Grass(i * 64, x * 64);
				} else {
					System.out.println("Split broke!");
				}
				world.add(worldTile);
			}

		}

		width = lines[0].length() * 64;

		height = lines.length * 64;

	}

	public void addToScene() {
		for (int i = 0; i < world.size(); i++) {
			SceneManager.getCurrentScene().ents.add(0, world.get(i));
		}
	}

	public void moveWorld(int x, int y) {

		yLoc += y;
		xLoc += x;

	}

	public float getXLocation() {
		return xLoc;
	}

	public float getYLocation() {
		return yLoc;
	}

	public float getHeight() {
		return height;
	}

	public float getWidth() {
		return width;
	}

}

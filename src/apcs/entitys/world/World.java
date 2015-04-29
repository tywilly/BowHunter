package apcs.entitys.world;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.scene.SceneManager;

public class World {
	
	private int width = 0;
	private int height = 0;
	
	private int xLoc = 0;
	private int yLoc = 0;

	private ArrayList<Entity> world = new ArrayList<Entity>();

	public void loadWorld(String location) {

		File worldFile = new File(location);

		try {
			Scanner scan = new Scanner(worldFile);

			int lineNum = 0;

			while (scan.hasNextLine()) {

				String[] split = scan.nextLine().split("");

				Entity worldTile = null;

				for (int i = 0; i < split.length; i++) {
					switch (split[i]) {
					case "1":
						worldTile = new Grass(i * 64, lineNum * 64);
						break;

					default:
						break;
					}
					world.add(worldTile);
				}
				lineNum++;
				
				width = split.length * 64;
				
			}

			height = lineNum * 64;
			
			scan.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void addToScene() {
		for (int i = 0; i < world.size(); i++) {
			SceneManager.getCurrentScene().ents.add(world.get(i));
		}
	}

	public void moveWorld(int x, int y) {
		
		yLoc += y;
		xLoc += x;
		
		for(int i=0;i<world.size();i++){
			world.get(i).setX((world.get(i).getX()+ x));
			world.get(i).setY((world.get(i).getY() + y));
		}
		
	}

	public int getXLocation(){
		return xLoc;
	}
	
	public int getYLocation(){
		return yLoc;
	}
	
	public int getHeight(){
		return height;
	}
	
	public int getWidth(){
		return width;
	}
	
}

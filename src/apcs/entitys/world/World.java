package apcs.entitys.world;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import apcs.entitys.mob.Mob;
import apcs.entitys.player.Player;
import apcs.entitys.player.PlayerMP;
import apcs.entitys.projectile.Projectile;

import com.tywilly.WillyEngine.entity.Entity;
import com.tywilly.WillyEngine.entity.text.Text;
import com.tywilly.WillyEngine.scene.SceneManager;

public class World {
	
	private int width = 0;
	private int height = 0;
	
	public static int xLoc = 0;
	public static int yLoc = 0;

	private ArrayList<Entity> world = new ArrayList<Entity>();

	public void loadWorld(String location) {

		File worldFile = new File(location);

		try {
			Scanner scan = new Scanner(worldFile);

			int lineNum = 0;

			while (scan.hasNextLine()) {

			    String line = scan.nextLine();
			    
				String[] split = new String[line.length()];
				
				for(int i=0;i< split.length;i++){
				    split[i] = line.substring(i, i+1);
				}

				Entity worldTile = null;

				for (int i = 0; i < split.length; i++) {
				    if(split[i].equalsIgnoreCase("1")){
				        worldTile = new Grass(i * 64, lineNum * 64);
				    }else{
				        System.out.println("Split broke!" + split[i]);
				    }
					world.add(worldTile);
				}
				lineNum++;
				
				width = split.length * 64;
				
			}

			height = lineNum * 64;
			
			scan.close();

			System.out.println("Loaded world!" + world.size());
			
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
		
//		for(int i=0;i<world.size();i++){
//			world.get(i).setX((world.get(i).getX() + x));
//			world.get(i).setY((world.get(i).getY() + y));
//		}
		
//		for(int i=0;i<SceneManager.getCurrentScene().ents.size();i++){
//			Entity ent = SceneManager.getCurrentScene().ents.get(i);
//			
//			if(!(ent instanceof Player || ent instanceof Text)){
//				ent.setX(ent.getX() + x);
//				ent.setY(ent.getY() + y);
//			}
//		}
		
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

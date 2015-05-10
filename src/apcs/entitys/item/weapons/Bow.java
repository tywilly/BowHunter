package apcs.entitys.item.weapons;

import com.tywilly.WillyEngine.scene.SceneManager;

import apcs.entitys.player.Player;
import apcs.entitys.projectile.Arrow;

public class Bow extends Weapon{

	@Override
	public void onAction(Player p, int xDir, int yDir) {
		// TODO Auto-generated method stub
		
		SceneManager.getCurrentScene().addEntity(new Arrow(p.getX(), p.getY(), yDir, yDir));
		
	}

}

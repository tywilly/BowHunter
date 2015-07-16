package apcs.entitys.item.weapons;

import apcs.entitys.player.Player;
import apcs.entitys.projectile.Arrow;

import com.tywilly.WillyEngine.scene.SceneManager;

public class Bow extends Weapon {

	@Override
	public void onAction(Player p, float xDir, float yDir, int angle) {
		// TODO Auto-generated method stub

		SceneManager.getCurrentScene().addEntity(
				new Arrow(p.getWorldX(), p.getWorldY(), xDir, yDir, angle, p));
		
	}

}

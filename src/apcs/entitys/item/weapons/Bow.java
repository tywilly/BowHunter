package apcs.entitys.item.weapons;

import apcs.entitys.player.Player;
import apcs.entitys.projectile.Arrow;

import com.tywilly.WillyEngine.scene.SceneManager;

public class Bow extends Weapon {

	@Override
	public void onAction(Player p, float xDir, float yDir, int angle) {
		// TODO Auto-generated method stub

	    Arrow ar = new Arrow(p.getX(), p.getY(), xDir, yDir, angle, p);
	    
	    ar.setDamageMod(p.getDamageModifier());
	    
		SceneManager.getCurrentScene().addEntity(ar);

	}

}

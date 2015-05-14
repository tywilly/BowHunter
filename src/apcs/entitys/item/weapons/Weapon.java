package apcs.entitys.item.weapons;

import apcs.entitys.item.ActionItem;
import apcs.entitys.player.Player;

public abstract class Weapon extends ActionItem{

	@Override
	public void onAction(Player p) {
		// TODO Auto-generated method stub
		
	}

	public abstract void onAction(Player p, float xDir, float yDir);
	
}

package apcs.entitys.item;

import apcs.entitys.player.Player;

public abstract class ActionItem extends Item{

	public abstract void onAction(Player p);
	
}

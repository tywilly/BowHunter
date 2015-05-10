package apcs.entitys.player;

import java.util.ArrayList;

import apcs.entitys.item.Item;

public class Inventory {

	Item hand;
	
	ArrayList<Item> backpack = new ArrayList<Item>();
	
	
	
	public Item getHand(){
		return hand;
	}
	
}

package apcs.entitys.player;

import java.util.ArrayList;

import apcs.entitys.item.Item;

public class Inventory {

	private Item hand;
	
	ArrayList<Item> backpack = new ArrayList<Item>();
	
	public void setHandItem(Item item){
		hand = item;
	}
	
	public Item getHandItem(){
		return hand;
	}
	
}

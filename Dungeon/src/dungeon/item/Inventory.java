package dungeon.item;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> items;
	
	public Inventory(){
		this.items = new ArrayList<Item>();
	}
	
	/**
	 * when the player adds an item into his inventory
	 * @param item
	 */
	public void addItem(Item item){
		int i=searchItem(item.getName());
		if(i!=-1)
			items.get(i).updateQuantity(item.getQuantity());
		else
			this.items.add(item);
	}
	
	/**
	 * when the player removes an item from his inventory
	 * @param item
	 */
	public void dropItem(Item item){
		int i=searchItem(item.getName());
		if(i!=-1)
			items.remove(i);
	}
	
	/**
	 * @param name
	 * @return the index of the item if the inventory contains it else return -1
	 */
	public int searchItem(String name){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
	
	/**
	 * update the number of item in the inventory when the player uses one
	 * @param name
	 * @param quantity
	 */
	public void useItem(String name,int quantity){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getName().equals(name))
				items.get(i).updateQuantity(-quantity);
		}
	}
	
	public String toString(){
		String list ="";
		for(int i=0;i<items.size();i++){
			list+=items.get(i).toString()+"\n";
		}
		return list;
	}
	
	/**
	 * @param itemName
	 * @return the item which is searching by the player
	 */
	public Item getItem(String itemName){
		Item item = null;
		if(this.searchItem(itemName) != -1)
			item = items.get(this.searchItem(itemName));
		return item;	
	}

}

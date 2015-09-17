package game;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item){
		int i=searchItem(item.getName());
		if(i!=-1)
			items.get(i).updateQuantity(item.getQuantity());
		else
			this.items.add(item);
	}
	
	public void dropItem(Item item){
		int i=searchItem(item.getName());
		if(i!=-1)
			items.remove(i);
	}
	
	//return the index of the item if the inventory contains it else return -1
	public int searchItem(String name){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getName().equals(name))
				return i;
		}
		return -1;
	}
	
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
	
	public Item getItem(String itemName){
		Item item = null;
		if(items.contains(itemName))
			item = items.get(this.searchItem(itemName));
		return item;	
	}

}

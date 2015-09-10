package game;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
	private List<Item> items = new ArrayList<Item>();
	
	public void addItem(Item item, int quantity){
		if(items.contains(item))
			item.updateQuantity(quantity);
		else
			this.items.add(item);
	}
	
	public void dropItem(Item item){
		if(items.contains(item))
			items.remove(item);
	}
	
	public boolean searchItem(String name){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getName().equals(name))
				return true;
		}
		return false;
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
			list+=items.get(i).toString();
		}
		return list;
	}

}

package dungeon.item;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fguilbert
 * in a chest, the player can find gold, weapons and potions
 */
public class Chest {
	
	private List<Item> drop;
	
	public Chest(List<Item> drop){
		this.setDrop(drop);
	}
	
	public Chest(){
		this.drop=new ArrayList<Item>();
		this.setBasicChest();
	}


	public void setBasicChest(){
		this.drop.add(new Potion("Health's potion",2));
	}
	
	public List<Item> getDrop() {
		return drop;
	}

	public void setDrop(List<Item> drop) {
		this.drop = drop;
	}
}

package dungeon.items;
import java.util.List;

import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;

/**
 * @author loic
 * Basic chest who contains an inventory of items
 */
public class Chest extends Inventory{
	
	
	/**
	 * @param items
	 */
	public Chest(List<StackItem> items){
		super();
		this.addListToInventory(items);
	}
	
	/**
	 * Empty constructor to initialize a chest with 2 HEALTH_POTION
	 */
	public Chest(){	
		super();
		this.setBasicChest();
	}


	/**
	 * initialize the chest's inventory with 2 HEALTH_POTION
	 */
	public void setBasicChest(){
		try {
			this.addItem(new StackItem(Item.HEALTH_POTION,2));
		} catch (FullInventoryException | MaxStacksException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * @return all the contents of the chest
	 */
	public List<StackItem> getDrop() {
		return this.getItems();
	}
}

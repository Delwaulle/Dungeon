package dungeon.game;


import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.items.Inventory;
import dungeon.items.StackItem;
import dungeon.items.Item;
import dungeon.level.Level;

/**
 * @author fguilbert
 * all the components for having a player
 */
public class Player extends Character{

	private Inventory inventory;
	
	/**
	 * We create the player
	 * @param name
	 */
	public Player(String name){
		super(name);
		this.maxHealth=20;
		this.currentHealth=20;
		this.damages=5;
		this.inventory = new Inventory();
		initializeBasicInventory();
	}
	
	/**
	 * When the player is created, we give him some basic stuff
	 */
	public void initializeBasicInventory(){
		try {
			this.inventory.addItem(new StackItem(Item.WOODEN_SWORD));
			this.inventory.addItem(new StackItem(Item.HEALTH_POTION,3));
		} catch (FullInventoryException | MaxStacksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * reinitialize the HP of the player and redirect him to the entrance of the level
	 * @param current level
	 */
	public void respawn(Level level){
		this.currentHealth=maxHealth;
		level.goToEntrance();
	}
	

	/**
	 * @return inventory
	 */
	public Inventory getInventory() {
		return inventory;
	}

	/**
	 * @param inventory
	 */
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}

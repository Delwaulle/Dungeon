package dungeon.game;


import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.items.StackItem;
import dungeon.items.Item;
import dungeon.level.Level;

/**
 * All the components for having a player
 * @author fguilbert
 * 
 */
public class Player extends Character{

	
	private Level currentLevel;
	/**
	 * We create the player
	 * @param name
	 */
	public Player(String name){
		super(name);
		this.maxHealth=20;
		this.currentHealth=maxHealth;
		this.damages=5;
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
	public void respawn(){
		this.currentHealth=maxHealth;
		this.currentLevel.goToEntrance();
		this.dead=false;
	}

	@Override
	public void die() {
		this.dead=true;
		System.out.println("You succumbed");
		System.out.println("You will redirect to the entrance of the level");
		this.respawn();
	}

	/**
	 * @param currentLevel
	 */
	public void setCurrentLevel(Level currentLevel) {
		this.currentLevel = currentLevel;
	}
	
	
	/**
	 * @return current level
	 */
	public Level getCurrentLevel() {
		return currentLevel;
	}
	
}

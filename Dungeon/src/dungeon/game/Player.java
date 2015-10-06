package dungeon.game;


import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.items.StackItem;
import dungeon.items.Item;
import dungeon.level.Level;
import dungeon.utils.Constants;

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
		initializeCaracteristics(1);
		initializeBasicInventory();
	}
	
	public void initializeCaracteristics(int level){
		this.maxHealth=Constants.BASIC_LIFE+(2*level);
		this.damages=Constants.BASIC_POWER+(2*level);
		this.pourcentCriticalHit=Constants.BASIC_POURCENTAGE_OF_CRITICAL_HIT;
		this.powerOfCriticalHit=Constants.BASIC_POWER_OF_CRITICAL_HIT+(2*level);
		
		this.currentHealth=maxHealth;
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

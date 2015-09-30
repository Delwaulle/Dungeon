package dungeon.game;

import dungeon.exceptions.FullInventoryException;
import dungeon.items.Chest;
import dungeon.items.StackItem;

/**
 * All the components for having a monster
 * @author fguilbert
 * 
 */
public class Monster extends Character{

	private Chest chest = new Chest();
	
	/**
	 * We create a monster with its state (not dead ^^),
	 * its strength and its life (HP:HealthPoints)
	 * @param name
	 */
	public Monster(String name){
		super(name);
		this.damages = 2;
		this.maxHealth = 5;
	}
	
	/**
	 * We create a monster with its state,
	 * its strength and its life (HP:HealthPoints)
	 * But, here, we specify its strength
	 * @param name
	 * @param damages
	 */
	public Monster (String name,int damages){
		super(name);
		this.damages=damages;
		this.maxHealth = 5;
	}

	/**
	 * We create a monster with its state,
	 * its strength and its life (HP:HealthPoints)
	 * But, here, we specify its strength
	 * @param name
	 * @param damages
	 * @param health
	 */
	public Monster (String name,int damages,int health){
		super(name);
		this.damages=damages;
		this.maxHealth = health;
	}

	/** add the drops table to the player inventory's
	 * 
	 */
	public void getDrop() {
		StackItem item;
		for(int i=0;i<this.chest.getDrop().size();i++){
			item=this.chest.getDrop().get(i);
			try {
				GameBoard.player.getInventory().addItem(item);
			} catch (FullInventoryException e) {
				e.printStackTrace();
			}
			System.out.println(item.toString());
		}
	}
	
	/**
	 * @return chest
	 */
	public Chest getChest() {
		return chest;
	}

	/**
	 * set a chest to the monster
	 * @param chest
	 */
	public void setChest(Chest chest) {
		this.chest = chest;
	}
}

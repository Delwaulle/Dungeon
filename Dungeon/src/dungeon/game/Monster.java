package dungeon.game;

import dungeon.item.Chest;
import dungeon.item.Item;

/**
 * @author fguilbert
 * all the components for having a monster
 */
public class Monster {
	
	private String name;
	private int damages, health;
	private boolean dead;
	private Chest chest = new Chest();
	
	/**
	 * We create a monster with its state (not dead ^^),
	 * its strength and its life (HP:HealthPoints)
	 * @param name
	 */
	public Monster(String name){
		this.name=name;
		this.dead = false;
		this.damages = 2;
		this.health = 5;
	}
	
	/**
	 * We create a monster with its state,
	 * its strength and its life (HP:HealthPoints)
	 * But, here, we specify its strength
	 * @param name
	 * @param damages
	 */
	public Monster (String name,int damages){
		this.name=name;
		this.damages=damages;
		this.dead = false;
		this.health = 5;
	}
	
	/**
	 * the monster is dead
	 */
	public void die(){
		this.dead = true;
	}
	
	/**
	 * @return the state of the monster (dead or not ?)
	 */
	public boolean isDead(){
		return this.dead;
	}
	
	/**
	 * when the monster is hit, its life is lower and the monster is maybe dead
	 * @param dmg
	 */
	public void getHit(int dmg){
		this.health = this.health - dmg;
		if(this.health <= 0)
			this.dead = true;
	}

	/**
	 * @return the name of the monster (example: "Camille")
	 */
	public String getName() {
		return name;
	}

	/**
	 * We choose the name of the monster (example: "Camille")
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return damages
	 */
	public int getDamages() {
		return damages;
	}

	/**
	 * We choose the strength of the monster
	 * @param damages
	 */
	public void setDamages(int damages) {
		this.damages = damages;
	}

	/** add the drops table to the player inventory's
	 * 
	 */
	public void getDrop() {
		Item item;
		for(int i=0;i<this.chest.getDrop().size();i++){
			item=this.chest.getDrop().get(i);
			GameBoard.player.getInventory().addItem(item);
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

	/**
	 * When a monster attacks a player
	 * @param player
	 */
	public void attack(Player player){
		player.getHit(this.damages);
	}
	
	/**
	 * @return health
	 */
	public int getHealth(){
		return this.health;
	}
	
	/**
	 * set the health of the monster
	 * @param health
	 */
	public void setHealth(int health){
		this.health = health;
	}

}

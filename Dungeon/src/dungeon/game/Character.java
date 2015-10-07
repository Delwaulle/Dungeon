package dungeon.game;

import dungeon.exceptions.FullInventoryException;
import dungeon.items.Inventory;
import dungeon.items.Item;
import dungeon.utils.Constants;


/**
 *  Etablish the caracteristics of a character
 * It can be a monster or a player
 * @author Loic
 *
 */
public abstract class Character {
	
	protected String name;
	protected int damages, maxHealth,currentHealth,pourcentCriticalHit,powerOfCriticalHit;
	protected boolean dead;
	protected Item currentWeapon;
	protected Inventory inventory;
	
	
	/**
	 * @param name
	 */
	public Character(String name){
		this.name=name;
		this.dead=false;
		this.inventory=new Inventory();
	}
	
	/**
	 * the character is attacking another character
	 * @return the damages
	 */
	public int attack(){
		if(isCriticalHit()){
			System.out.println("Critical hit !");
			return this.getDamagesWithWeapon()+powerOfCriticalHit;
		}
		//normal hit
		return this.getDamagesWithWeapon();
	}
	
	/**
	 * @return the player's damage which is added to the damage of the weapon
	 */
	public int getDamagesWithWeapon(){
		if(currentWeapon != null)
			return this.damages + this.currentWeapon.getPower();
		return this.damages;
	}
		


	/**
	 * @return if the character is making a critical hit or not
	 */
	public boolean isCriticalHit(){
		int random = (int)(Math.random() * 100)+1;
		if(random<=this.pourcentCriticalHit)
			return true;
		return false;
	}
	
	
	
	
	/**
	 * update the health of the character with the damages
	 * @param dmg
	 */
	public void getHit(int dmg){
		this.currentHealth -= dmg;
		if(this.currentHealth <= 0)
			this.die();
		else		
			System.out.println(this.name+" has now " + this.getCurrentHealth() + " HP");
	}
	
	
	/** 
	 * add all the item of the current character to the character inventory's passed in param
	 */
	public void getDrop(Character character) {
			try {
				this.inventory.addListToInventory(character.getInventory().getItems());
			} catch (FullInventoryException e) {
				System.out.println("You are full. Sorry you can't get the drop");
			}
	}
	
	/**
	 * @param level
	 * @return the pourcentage of critical hit for a character thanks the level
	 */
	public int calculatePourcentCriticalHitByLevel(int level){
		return (int)(((double)level/Constants.MAX_LEVELS)*(Constants.MAX_POURCENT_CRITICAL_HIT-Constants.BASIC_POURCENTAGE_OF_CRITICAL_HIT));
	}
	
	
	
	/*
	* ===========================================================================
	* 						Getters and setters
	*/
	

	/**
	 * @return the name of the character (example: "Camille")
	 */
	public String getName() {
		return name;
	}

	/**
	 * We choose the name of the character (example: "Camille")
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

	/**
	 * @return max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param max health
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @param damages
	 */
	public void setDamages(int damages) {
		this.damages = damages;
	}
	

	/**
	 * @return the damages 
	 */
	public int getDamages(){
		return this.damages;
	}
	
	/**
	 * @return the luck to make a critical hit
	 */
	public int getPourcentCriticalHit() {
		return pourcentCriticalHit;
	}

	/**
	 * @param pourcentCriticalHit
	 */
	public void setPourcentCriticalHit(int pourcentCriticalHit) {
		this.pourcentCriticalHit = pourcentCriticalHit;
	}

	/**
	 * @return the power of the character during a critical hit
	 */
	public int getPowerOfCriticalHit() {
		return powerOfCriticalHit;
	}

	/**
	 * @param powerOfCriticalHit
	 */
	public void setPowerOfCriticalHit(int powerOfCriticalHit) {
		this.powerOfCriticalHit = powerOfCriticalHit;
	}
	
	/**
	 * @return lives
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * @param lives
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	
	/**
	 * @return currentWeapon
	 */
	public Item getCurrentWeapon() {
		return currentWeapon;
	}

	/**
	 * @param currentWeapon
	 */
	public void setCurrentWeapon(Item currentWeapon) {
		if(currentWeapon.isEquipable())
			this.currentWeapon = currentWeapon;
		else
			System.out.println("This is not an equipable item !");
	}
	
	
	/**
	 * @return the state of the character (dead or not ?)
	 */
	public boolean isDead(){
		return this.dead;
	}
	

	/**
	 * @return inventory of the character
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
	
	/*
	* ===========================================================================
	* 						Abstract
	*/
	
	
	/**
	 * the character dies
	 */
	public abstract void die();
	
	/**
	 * Initialize all the caracteristics for a character with the number of the level to up his carac
	 * @param level
	 */
	public abstract void initializeCaracteristics(int level);
}

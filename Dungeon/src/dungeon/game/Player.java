package dungeon.game;


import dungeon.item.Inventory;
import dungeon.item.Potion;
import dungeon.item.Weapon;

/**
 * @author fguilbert
 * all the components for having a player
 */
public class Player {
	
	private int lives=5, health=20, damages=5;
	private boolean dead;
	private int pourcentCriticalHit=50;
	private int powerOfCriticalHit=2;
	private String name;
	private Inventory inventory;
	


	/**
	 * We create the player
	 * @param name
	 */
	public Player(String name){
		this.name=name;
		this.dead = false;
		initializeBasicInventory();
	}
	
	/**
	 * When the player is created, we give him some basic stuff
	 */
	public void initializeBasicInventory(){
		this.inventory=new Inventory();
		this.inventory.addItem(new Weapon("Wooden sword"));
		this.inventory.addItem(new Potion("Health's potion",1,3));
	}
	
	/**
	 * the player dies
	 */
	public void die(){
		this.dead = true;
	}

	
	/**
	 * the player is attacking the monster and the monster's HP are updated
	 * @param monster
	 */
	public void attack(Monster monster){
		if(isCriticalHit()){
			System.out.println("Critical hit !");
			monster.getHit(this.damages*powerOfCriticalHit);
		}
		monster.getHit(this.damages);
	}
	
	/**
	 * @return if the player is making a critical hit or not
	 */
	public boolean isCriticalHit(){
		int random = (int)(Math.random() * 100)+1;
		if(random<=this.pourcentCriticalHit)
			return true;
		return false;
	}
	
	/**
	 * When the player is hit by the monster, his health is lower
	 * @param dmg
	 */
	public void getHit(int dmg){
		this.health = this.health-dmg;
	}
	
	
/*
* ===========================================================================
* 						Getters and setters
*/
	
	/**
	 * @param damages
	 */
	public void setDamages(int damages) {
		this.damages = damages;
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
	 * @return the power of the player during a critical hit
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
	 * @return the state of the player : dead or alive
	 */
	public boolean isDead(){
		return this.dead;
	}
	// getDamage, c'est pour recevoir les données des dommages faits par le joueur ou subit
	// par le joueur ?
	/**
	 * @return the damages 
	 */
	public int getDamages(){
		return this.damages;
	}
	
	/**
	 * @return the player's damage which is added to the damage of the weapon
	 */
	public int getFullDamages(){
		return this.damages + ((Weapon)this.getInventory().getItem("Wooden sword")).getDamages();
	}
	
	/**
	 * @return lives
	 */
	public int getLives() {
		return lives;
	}

	/**
	 * @param lives
	 */
	public void setLives(int lives) {
		this.lives = lives;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
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

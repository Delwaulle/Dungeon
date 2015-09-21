package dungeon.game;


import dungeon.item.Inventory;
import dungeon.item.Potion;
import dungeon.item.Weapon;

public class Player {
	
	private int lives=5, health=20, damages=5;
	private boolean dead;
	private int pourcentCriticalHit=50;
	private int powerOfCriticalHit=2;
	private String name;
	private Inventory inventory;
	


	public Player(String name){
		this.name=name;
		this.dead = false;
		initializeBasicInventory();
	}
	
	public void initializeBasicInventory(){
		this.inventory=new Inventory();
		this.inventory.addItem(new Weapon("Wooden sword"));
		this.inventory.addItem(new Potion("Health's potion",1,3));
	}
	
	public void die(){
		this.dead = true;
	}

	
	public void attack(Monster monster){
		if(isCriticalHit()){
			System.out.println("Critical hit !");
			monster.getHit(this.damages*powerOfCriticalHit);
		}
		monster.getHit(this.damages);
	}
	
	public boolean isCriticalHit(){
		int random = (int)(Math.random() * 100)+1;
		if(random<=this.pourcentCriticalHit)
			return true;
		return false;
	}
	
	public void getHit(int dmg){
		this.health = this.health-dmg;
	}
	
	
/*
* ===========================================================================
* 						Getters and setters
*/
	
	public void setDamages(int damages) {
		this.damages = damages;
	}
	
	public int getPourcentCriticalHit() {
		return pourcentCriticalHit;
	}

	public void setPourcentCriticalHit(int pourcentCriticalHit) {
		this.pourcentCriticalHit = pourcentCriticalHit;
	}

	public int getPowerOfCriticalHit() {
		return powerOfCriticalHit;
	}

	public void setPowerOfCriticalHit(int powerOfCriticalHit) {
		this.powerOfCriticalHit = powerOfCriticalHit;
	}
	
	
	public boolean isDead(){
		return this.dead;
	}
	
	public int getDamages(){
		return this.damages;
	}
	
	public int getFullDamages(){
		return this.damages + ((Weapon)this.getInventory().getItem("Wooden sword")).getDamages();
	}
	
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Inventory getInventory() {
		return inventory;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

}

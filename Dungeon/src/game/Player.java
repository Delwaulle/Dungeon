package game;

public class Player {
	
	private int lives=5, health=20, damages=5;
	private boolean dead;
	private String name;
	private Inventory inventory;
	
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
	
	public boolean isDead(){
		return this.dead;
	}
	
	public int getDamages(){
		return this.damages;
	}
	
	public int getFullDamages(){
		return this.damages + ((Weapon)this.getInventory().getItem("Wooden sword")).getDamages();
	}
	
	public void attack(Monster monster){
		monster.getHit(this.damages);
	}
	
	public void getHit(int dmg){
		this.health = this.health-dmg;
	}

}

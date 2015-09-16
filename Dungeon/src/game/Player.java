package game;

public class Player {
	
	private int lives=5;
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
		initializeBasicInventory();
	}
	
	public void initializeBasicInventory(){
		this.inventory=new Inventory();
		this.inventory.addItem(new Weapon("Wooden sword"));
		this.inventory.addItem(new Potion("Health's potion",1,3));
	}

}

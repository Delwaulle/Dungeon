package dungeon.game;

public class Monster {
	
	private String name;
	private int damages, health;
	private boolean dead;
	private Item[] drop=new Item[]{new Potion("Health's potion",2)};
	
	public Monster(String name){
		this.name=name;
		this.dead = false;
		this.damages = 2;
		this.health = 5;
	}
	
	public void die(){
		this.dead = true;
	}
	
	public boolean isDead(){
		return this.dead;
	}
	
	public void getHit(int dmg){
		this.health = this.health - dmg;
		if(this.health <= 0)
			this.dead = true;
	}
	
	public Monster (String name,int damages){
		this.name=name;
		this.damages=damages;
		this.dead = false;
		this.health = 5;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDamages() {
		return damages;
	}

	public void setDamages(int damages) {
		this.damages = damages;
	}

	//add the drop table to the player inventory's
	public void getDrop() {
		for(int i=0;i<drop.length;i++){
			GameBoard.player.getInventory().addItem(drop[i]);
			System.out.println(drop[i].toString());
		}
		
	}
	
	public void attack(Player player){
		player.getHit(this.damages);
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void setHealth(int health){
		this.health = health;
	}

}

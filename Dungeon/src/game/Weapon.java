package game;

public class Weapon extends Item{

	private int damages;
	private String durability;
	public int getDamages() {
		return damages;
	}
	public void setDamages(int damages) {
		this.damages = damages;
	}
	public String getDurability() {
		return durability;
	}
	public void setDurability(String durability) {
		this.durability = durability;
	}
	
	public String toString(){
		return this.name+" (x"+this.quantity+") - Damages : "+
				this.damages +" - Durability : "+this.durability;
	}
}

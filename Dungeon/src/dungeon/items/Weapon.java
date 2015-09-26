package dungeon.items;

public class Weapon extends Item{

	public Weapon(String name) {
		super(name);
	}

	private int damages=5;
	//private int durability=10;
	/**
	 * @return the damages of the weapon
	 */
	public int getDamages() {
		return damages;
	}
	/**
	 * set the damages of the weapon
	 * @param damages
	 */
	public void setDamages(int damages) {
		this.damages = damages;
	}
	/*public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}*/
	
	public String toString(){
		return this.name+" (x"+this.quantity+") - Damages : "+
				this.damages;// - Durability : +this.durability;
	}
}

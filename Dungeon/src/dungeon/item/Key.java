package dungeon.item;

public class Key extends Item{

	
	
	public Key(){
		super("key");

	}
	
	public String toString(){
		return this.name+" (x"+this.quantity+") ";
	}
}

package dungeon.items;

/**
 * @author fguilbert
 * the key is for opening locked doors and maybe some chests
 */
public class Key extends Item{

	
	
	public Key(){
		super("key");

	}
	
	public String toString(){
		return this.name+" (x"+this.quantity+") ";
	}
}

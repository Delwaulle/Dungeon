package dungeon.game;

public class Key extends Item{
	
	private String roomName;
	private String direction;
	
	
	public Key(String roomName,String direction){
		super("key");
		this.roomName=roomName;
		this.direction=direction;
	}
	
	public String toString(){
		return this.name+" (x"+this.quantity+") - Room : "+
				this.roomName+ " - direction : "+
						this.direction;
	}
}

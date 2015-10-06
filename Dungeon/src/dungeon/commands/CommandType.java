package dungeon.commands;

public enum CommandType {
	USE(1,"use : use an item in your inventory. You must specify the name of the item. Ex: \"use HEALTH_POTION\"");

	
	private int id;
	private String description;
	
	CommandType(int id,String description){
		this.id=id;
		this.description=description;
	}

	public int getId() {
		return id;
	}


	public String getDescription() {
		return this.description;
	}
}
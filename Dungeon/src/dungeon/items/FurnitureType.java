package dungeon.items;

public enum FurnitureType {

	CARPET(1,"under the carpet"),
	PICTURE(2,"behind the picture"),
	SOFA(3,"behind the sofa"),
	TABLE(4,"under the table");
	
	private int id;
	private String action;
	
	FurnitureType(int id, String action){
		this.id=id;
		this.action=action;
	}

	public int getId() {
		return id;
	}

	public String getAction() {
		return action;
	}
}

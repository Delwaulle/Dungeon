package dungeon.actions;

public enum Furniture {

	CARPET(1,"carpet"),
	PICTURE(2,"picture"),
	SOFA(3,"sofa"),
	TABLE(4,"table");
	
	private int id;
	private String name;
	
	Furniture(int id, String name){
		this.id=id;
		this.name=name;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}

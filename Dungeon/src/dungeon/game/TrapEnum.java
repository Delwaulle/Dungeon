package dungeon.game;

public enum TrapEnum {

	GAZ(1,"Gaz", 5),
	FIRE(2, "Fire", 10),
	HIDDEN_SPIKES(3, "Hidden Spikes", 15),
	ROCKS_FELL(4, "Rocks Fell", 20);
	
	/**
	 * id of the enum, power of the trap
	 */
	private int id;
	private String name;
	private int power;
	
	TrapEnum(int id, String name, int power) {
		this.id = id;
		this.power = power;
		this.name = name;
	}
	
	public int getId(){
		return this.id;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}

package dungeon.game;

/**
 * @author Camille
 * All type of trap can be find in the game
 */
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
	
	/**
	 * @param id
	 * @param name
	 * @param power
	 */
	TrapEnum(int id, String name, int power) {
		this.id = id;
		this.power = power;
		this.name = name;
	}
	
	/**
	 * @return id of the trap
	 */
	public int getId(){
		return this.id;
	}

	/**
	 * @return power of the trap
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power
	 */
	public void setPower(int power) {
		this.power = power;
	}

	/**
	 * @return name of the trap
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

}

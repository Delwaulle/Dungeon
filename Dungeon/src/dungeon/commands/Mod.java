package dungeon.commands;

/**
 * @author Loic
 * Differents mod for differents commands
 */
public enum Mod {
	
	BATTLE_MOD(1),
	BASIC_MOD(2),
	EXCAVATION_MOD(3),
	TREASURE_MOD(4),
	;

	private int id;
	
	/**
	 * @param id
	 */
	Mod(int id){
		this.id=id;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
}

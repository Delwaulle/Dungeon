package dungeon.commands;

/**
 * @author Loic
 * Differents mod for differents commands
 */
public enum Mod {
	
	BASIC_MOD(1,new String[]{"go","stats","help","equip","describe","inventory","use","drop"}),
	BATTLE_MOD(2,new String[]{"hit","stats","help","equip","inventory","use"}),
	EXCAVATION_MOD(3,new String[]{"go","stats","help","equip","describe","inventory","use","drop","examine"}),
	;

	private int id;
	private String[] listCommands;
	
	/**
	 * @param id
	 */
	Mod(int id){
		this.id=id;
	}

	/**
	 * @param id
	 * @param listCommands
	 */
	Mod(int id,String[] listCommands){
		this.id=id;
		this.listCommands=listCommands;
	}
	
	/**
	 * @return list of the commands associate to the mod
	 */
	public String[] getListCommands() {
		return listCommands;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
}

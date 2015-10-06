package dungeon.commands;

/**
 * @author Loic
 * Differents mod for differents commands
 */
public enum Mod {
	
	BASIC_MOD(1,new CommandType[]{CommandType.USE}),
	BATTLE_MOD(2,new CommandType[]{CommandType.USE}),
	EXCAVATION_MOD(3,new CommandType[]{CommandType.USE}),
	TREASURE_MOD(4,new CommandType[]{CommandType.USE})
	;

	private int id;
	private CommandType[] listCommands;
	
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
	Mod(int id,CommandType[] listCommands){
		this.id=id;
		this.listCommands=listCommands;
	}
	
	/**
	 * @return list of the commands associate to the mod
	 */
	public CommandType[] getListCommands() {
		return listCommands;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
	public String toString(){
		String str="";
		for(int i =0;i<listCommands.length;i++){
			str+="- "+listCommands[i].getDescription()+"\n";
		}
		return str;
	}
	
}

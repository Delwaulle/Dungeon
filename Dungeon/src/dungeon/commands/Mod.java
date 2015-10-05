package dungeon.commands;

/**
 * @author Loic
 * Differents mod for differents commands
 */
public enum Mod {
	
	BASIC_MOD(1,new CommandEnum[]{CommandEnum.USE}),
	BATTLE_MOD(2,new CommandEnum[]{CommandEnum.USE}),
	EXCAVATION_MOD(3,new CommandEnum[]{CommandEnum.USE}),
	TREASURE_MOD(4,new CommandEnum[]{CommandEnum.USE})
	;

	private int id;
	private CommandEnum[] listCommands;
	
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
	Mod(int id,CommandEnum[] listCommands){
		this.id=id;
		this.listCommands=listCommands;
	}
	
	/**
	 * @return list of the commands associate to the mod
	 */
	public CommandEnum[] getListCommands() {
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

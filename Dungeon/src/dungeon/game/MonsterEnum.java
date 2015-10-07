package dungeon.game;

/**
 * @author Loic
 * All the monsters which are in the game
 */
public enum MonsterEnum {	
	DEVIL_CAT(1,"devil cat",10,6),
	SPIDER(2,"spider",25,3),
	;
	
	private int id;
	private String name;
	private int health;
	private int power;
	
	/**
	 * @param id
	 * @param name
	 * @param health
	 * @param power
	 */
	MonsterEnum(int id,String name, int health, int power){
		this.id=id;
		this.name=name;
		this.health=health;
		this.power=power;
	}

	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	 /**
	 * @return health
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * @return power
	 */
	public int getPower() {
		return power;
	}
}

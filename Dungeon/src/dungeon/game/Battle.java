package dungeon.game;

/**
 * @author fguilbert
 * The scenario of the fight between a player and a monster
 */
public class Battle {
	
	
	private Player player;
	private Monster monster;
	
	/**
	 * create a new battle
	 * @param player
	 * @param monster
	 */
	public Battle(Player player, Monster monster){
		this.player = player;
		this.monster = monster;
	}
	
	/**
	 * scenario of a fight between a player and a monster
	 * @return the result of the fight
	 * 0 if the monster dies
	 * 1 if the player dies
	 */
	public int fight(){
		while(!monster.isDead() && !player.isDead()){
			player.attack(monster);
			if(!monster.isDead())
				monster.attack(player);
		}
		if(monster.isDead())
			return 0;
		else
			return 1;
	}

	/**
	 * @return the player
	 */
	public Player getPlayer() {
		return this.player;
	}

	/**
	 * set the player
	 * @param player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @return the monster
	 */
	public Monster getMonster() {
		return this.monster;
	}

	/**
	 * set the monster
	 * @param monster
	 */
	public void setMonster(Monster monster) {
		this.monster = monster;
	}

}

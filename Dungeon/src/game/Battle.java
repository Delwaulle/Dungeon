package game;

public class Battle {
	
	private Player player;
	private Monster monster;
	
	public Battle(Player player, Monster monster){
		this.setPlayer(player);
		this.setMonster(monster);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Monster getMonster() {
		return monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

}

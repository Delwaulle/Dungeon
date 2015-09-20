package dungeon.game;

public class Battle {
	
	private Player player;
	private Monster monster;
	
	public Battle(Player player, Monster monster){
		this.player = player;
		this.monster = monster;
	}
	
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

	public Player getPlayer() {
		return this.player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Monster getMonster() {
		return this.monster;
	}

	public void setMonster(Monster monster) {
		this.monster = monster;
	}

}

package dungeon.game;

public class Battle {
	
	private Player player;
	private Monster monster;
	private int result;
	
	public Battle(Player player, Monster monster){
		this.player = player;
		this.monster = monster;
		this.result = 0;
	}
	
	public void fight(){
		
		while(!monster.isDead() && !player.isDead()){
			player.attack(monster);
			if(!monster.isDead())
				monster.attack(player);
			
		}
		
		if(monster.isDead())
			result = 0;
		else
			result = 1;
		
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

	public int getWinner() {
		return this.result;		
	}

}

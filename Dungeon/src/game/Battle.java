package game;

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
		
		//boucle infine sur player.attack(monster);
		while(!monster.isDead() || !player.isDead()){
			player.attack(monster);
			System.out.println("player attacks monster");
			if(!monster.isDead()){
				monster.attack(player);
				System.out.println("monster attacks player");
			}
		}
		
		if(monster.isDead()){
			result = 0;
			System.out.println("The Monster is dead");
		}
		else{
			result = 1;
			System.out.println("You died !");
		}
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

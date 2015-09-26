package dungeon.game;

import java.util.Scanner;

import dungeon.items.Item;

/**
 * @author fguilbert
 * The scenario of the fight between a player and a monster
 */
public class Battle {
	
	
	private Player player;
	private Monster monster;
	private Scanner scanner=new Scanner(System.in);
	
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
	 * @return the winner
	 */
	public Character fight(){
		while(!monster.isDead() && !player.isDead()){
			System.out.println("What do you want to do ?");
			System.out.println("Press \"1\" to hit the monster");
			System.out.println("Press \"2\" to use a potion");
			
			int answer = scanner.nextInt();
			switch (answer) {
			case 1:
				//the player attacks the monster 
				int playerDamages =player.attack();
				monster.getHit(playerDamages);
				System.out.println("You imposed "+playerDamages+" damages to " + monster.getName());
				System.out.println(monster.getName() + " has " + monster.getCurrentHealth() + " HP");
				break;
			case 2:
				//player.getInventory().useItem(name, quantity); // list all the potion
				
				//int item = scanner.nextInt();
				break;
			default:
				System.out.println("I don't know what you mean");
				fight();
			}
			
			//the monster attacks the player	
			if(!monster.isDead()){
				int monsterDamages = monster.attack();
				player.getHit(monsterDamages);
				System.out.println("The "+monster.getName()+ " imposed you "+monsterDamages+" damages");
				System.out.println("You have " + player.getCurrentHealth() + " HP");
			}
		}
		
		if(monster.isDead()){
			System.out.println("Good job, you have killed "+monster.getName());
			System.out.println("Let's see your drop !");
			getDrop();
			System.out.println("You have now " + player.getCurrentHealth() + " HP");
			return player;
		}			
		else
			return monster;
	}
	
	/** add the drops table to the player inventory's
	 * 
	 */
	public void getDrop() {
		Item item;
		for(int i=0;i<this.monster.getChest().getDrop().size();i++){
			item=this.monster.getChest().getDrop().get(i);
			this.player.getInventory().addItem(item);
			System.out.println(item.toString());
		}
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

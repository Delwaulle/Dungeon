package dungeon.game;

import dungeon.commands.CommandFactory;
import dungeon.commands.ConsumeHealPotionCommand;
import dungeon.utils.SecureInput;

/**
 * The scenario of the fight between a player and a monster
 * @author fguilbert
 * 
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
	 * @return the winner
	 */
	public Character fight(){
		CommandFactory commandFactory = new CommandFactory();
		while(!monster.isDead() && !player.isDead()){
			System.out.println("What do you want to do ?");
			System.out.println("Enter \"1\" to hit the monster");
			System.out.println("Enter \"2\" to use a potion");
			int answer = SecureInput.getIntSecureInput();
			switch (answer) {
			case 1:
				//the player attacks the monster 
				int playerDamages =player.attack();
				monster.getHit(playerDamages);
				System.out.println("You imposed "+playerDamages+" damages to " + monster.getName());
				System.out.println(monster.getName() + " has " + monster.getCurrentHealth() + " HP");
				break;
			case 2:
				String potionName="";
				/*if(cmd.length!=2)
					potionName=" ";
				else
					potionName=cmd[1];*/
				commandFactory.setCommand(new ConsumeHealPotionCommand(this.player,potionName));
				commandFactory.invoke();
				break;
			case 3:
				//equip a weapon
				break;
			case 4:
				// flee during the battle - respawn the monster
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
			System.out.println(monster.getInventory().toString());
			player.getDrop(monster);
			System.out.println("You have now " + player.getCurrentHealth() + " HP");
			return player;
		}			
		else
			return monster;
	}
	
	// ====================== GETTERS AND SETTERS ===========================
	
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

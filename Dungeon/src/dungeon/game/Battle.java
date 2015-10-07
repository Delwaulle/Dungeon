package dungeon.game;

import dungeon.commands.CommandFactory;
import dungeon.commands.HitCommand;
import dungeon.commands.Mod;
import dungeon.utils.SecureInput;

/**
 * The scenario of the fight between a player and a monster
 * @author fguilbert
 * 
 */
public class Battle {
	
	
	private Player player;
	private Monster monster;
	private CommandFactory commandFactory;
	
	/**
	 * create a new battle
	 * @param player
	 * @param monster
	 */
	public Battle(Player player, Monster monster){
		this.player = player;
		this.monster = monster;
		this.commandFactory=new CommandFactory(Mod.BATTLE_MOD);
	}
	
	/**
	 * scenario of a fight between a player and a monster
	 */
	public void fight(Character aggressor){
		if(aggressor.equals(player)){
			if(!player.getCurrentLevel().getCurrentRoom().getName().equals("entrance")){
				if(player.getCurrentWeapon()==null)
					System.out.println("/!\\ YOU HAVEN'T EQUIPPED WEAPON");
				System.out.println("What do you want to do ? (Enter help to show all the possible commands)");
				System.out.print("> ");	
				String answer = SecureInput.getNoEmptyStringInput();
				String[] cmd = answer.split(" ",2);
				if(!this.commandFactory.interpretCommand(cmd, aggressor, null, null, monster, null))
					fight(player);
				else
					fight(monster);
			}
		}
		else{
			//the aggressor is the monster	
			if(!monster.isDead()){
				commandFactory.setCommand(new HitCommand(this.monster,this.player));
				commandFactory.invoke();
				fight(this.player);
			}
		}
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

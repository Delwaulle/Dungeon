package dungeon.game;

import dungeon.commands.CommandFactory;
import dungeon.commands.ConsumeHealPotionCommand;
import dungeon.commands.EquipItemCommand;
import dungeon.commands.HitCommand;
import dungeon.utils.SecureInput;

/**
 * The scenario of the fight between a player and a monster
 * @author fguilbert
 * 
 */
public class Battle {
	
	
	private Player player;
	private Monster monster;
	private CommandFactory commandFactory=GameBoard.commandFactory;
	
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
	 */
	public void fight(Character aggressor){
		if(aggressor.equals(player)){
			if(!player.getCurrentLevel().getCurrentRoom().getName().equals("entrance")){
				if(player.getCurrentWeapon()==null)
					System.out.println("/!\\ YOU HAVEN'T EQUIPPED WEAPON");
				System.out.println("What do you want to do ?");
				System.out.println("Enter \"hit\" to hit the monster");
				System.out.println("Enter \"use + potion name\" to use a potion");
				System.out.println("Enter \"equip + weapon name\" to equip a weapon");
				String answer = SecureInput.getNoEmptyStringInput();
				String[] cmd = answer.split(" ",2);
				switch (cmd[0]) {
				case "hit":
					//the player attacks the monster 
					commandFactory.setCommand(new HitCommand(this.player,this.monster));
					commandFactory.invoke();
					fight(this.monster);
					break;
				case "use":
					String potionName="";
					if(cmd.length!=2)
						potionName=" ";
					else
						potionName=cmd[1];
					commandFactory.setCommand(new ConsumeHealPotionCommand(this.player,potionName));
					commandFactory.invoke();
					fight(this.player);
					break;
				case "equip":
					String equipName="";
					if(cmd.length!=2)
						equipName=" ";
					else
						equipName=cmd[1];
					commandFactory.setCommand(new EquipItemCommand(this.player,equipName));
					commandFactory.invoke();
					fight(this.player);
					break;
				default:
					System.out.println("I don't know what you mean");
					fight(player);
				}
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

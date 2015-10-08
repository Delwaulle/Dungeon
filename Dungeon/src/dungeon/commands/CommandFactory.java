package dungeon.commands;

import dungeon.game.Character;
import dungeon.game.Monster;
import dungeon.items.Furniture;
import dungeon.level.Level;
import dungeon.level.Room;


/**
 * @author Loic
 * Call the execute method of a command without the knowledge of this command
 */
public class CommandFactory {

	private Command command;
	private Mod currentCommandMod;
	
	/**
	 * @param commandMod
	 */
	public CommandFactory(Mod commandMod){
		this.currentCommandMod=commandMod;
	}

	/**
	 * this methode call the execution of the current command
	 */
	public void invoke() {
		command.execute();
	}	
	
	/**
	 * execute the command associate to the user input
	 * @param user input (command + args)
	 * @return if the command passed to the next action or repeat it
	 */
	public boolean interpretCommand(String [] cmd,Character character,Level level,Room room,Monster monster,Furniture furniture){
		boolean isTerminal=false;
		if(isValidCommandWithMod(cmd[0])){
			switch(cmd[0]){
			case "help":
				this.setCommand(new HelpCommand(this.currentCommandMod));
				isTerminal=false;
				break;
			case "go":
				String directionName="";
				if(cmd.length!=2)
					directionName=" ";
				else
					directionName=cmd[1];
				this.setCommand(new GoCommand(level,directionName));
				isTerminal=true;
				break;
			
			case "describe":
				this.setCommand(new DescribeCommand(room));
				isTerminal=false;
				break;			
			case "inventory":
				this.setCommand(new ShowInventoryCommand(character));
				isTerminal=false;
				break;			
			case "use":
				String potionName="";
				if(cmd.length!=2)
					potionName=" ";
				else
					potionName=cmd[1];
				this.setCommand(new ConsumePotionCommand(character,potionName));
				isTerminal=false;
				break;		
			case "equip":
				String equipName="";
				if(cmd.length!=2)
					equipName=" ";
				else
					equipName=cmd[1];
				this.setCommand(new EquipItemCommand(character,equipName));
				isTerminal=false;
				break;				
			case "stats":
				this.setCommand(new StatsCommand(character));
				isTerminal=false;
				break;
			case "drop":
				String itemName;
				if(cmd.length!=2)
					itemName=" ";
				else
					itemName=cmd[1];
				this.setCommand(new DropCommand(character,itemName));
				isTerminal=false;
				break;	
			case "hit":
				this.setCommand(new HitCommand(character,monster));
				isTerminal=true;
				break;
			case "examine":
				this.setCommand(new ExamineCommand(furniture));
				isTerminal=false;
				break;
			default:
				System.out.println("I don't know what you mean. Type \"help\" to show the differents commands.");
				isTerminal=false;
			}	
			//call the execution of the command
			this.invoke();
		}
		else{
			System.out.println("Non valid command, enter \"help\" to show all possibles commands");
		}
		return isTerminal;
		
	}
	
	/**
	 * @param name of the command
	 * @return if it is a valid command with the current mod
	 */
	public boolean isValidCommandWithMod(String cmd){
		String[] listCmd = this.currentCommandMod.getListCommands();
		boolean isPresent=false;
		for(int i=0;i<listCmd.length;i++){
			if(cmd.equals(listCmd[i]))
				isPresent=true;
		}
		return isPresent;
	}

	/**
	 * @param command
	 */
	public void setCommand(Command command) {
		this.command = command;
	}
	
	/**
	 * @return the current mod
	 */
	public Mod getCurrentCommandMod() {
		return currentCommandMod;
	}
	
	/**
	 * @param currentCommandMod
	 */
	public void setCurrentCommandMod(Mod currentCommandMod) {
		this.currentCommandMod = currentCommandMod;
	}


}

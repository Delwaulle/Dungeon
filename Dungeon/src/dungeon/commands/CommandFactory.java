package dungeon.commands;

import java.util.HashMap;
import java.util.Map;


/**
 * @author Loic
 * Call the execute method of a command without the knowledge of this command
 */
public class CommandFactory {

	private Command command;
	private Mod currentCommandMod;
	private Map<Mod,HashMap<String,Command>> allCommands= new HashMap<>();
	private Map<String,Command> possibleCommandsWithMod= new HashMap<>();

	public CommandFactory(Command command) {
		this.command = command;
	}
	


	public void invoke() {
		command.execute();
	}
	
	public void initializeAllCommands(){
		
	}
	
	/**
	 * Display all the commands associate to the current commands Mod
	 */
	public void showPossibleCommands(){
		for(String cmd : possibleCommandsWithMod.keySet())
			System.out.println(possibleCommandsWithMod.get(cmd).getDescription());
	}
	
	public CommandFactory(Mod commandMod){
		this.currentCommandMod=commandMod;
	}
	
	public CommandFactory(){}

	public void setCommand(Command command) {
		this.command = command;
	}
	
	public Mod getCurrentCommandMod() {
		return currentCommandMod;
	}


}

package dungeon.commands;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Loic
 * Call the execute method of a command without the knowledge of this command
 */
public class CommandFactory {

	private Command command;
	private Mod currentCommandMod;
	private Map<Mod,List<String>> allCommands= new HashMap<>();
	private Map<String,Command> stringToCommand= new HashMap<>();

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
		System.out.println(currentCommandMod.toString());
	}
	
	public void interpretCommand(String [] cmd){
		if(isValidCommandWithMod(cmd[0])){
			
		}
		else{
			System.out.println("Non valid command, enter \"help\" to show all possibles commands");
		}
		
	}
	
	public boolean isValidCommandWithMod(String cmd){
		List<String> cmdList = this.allCommands.get(this.currentCommandMod);
		return cmdList.contains(cmd);
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
	
	public void setCurrentCommandMod(Mod currentCommandMod) {
		this.currentCommandMod = currentCommandMod;
		//maj possible cmd
	}


}

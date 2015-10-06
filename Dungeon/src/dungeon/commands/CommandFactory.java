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
		/*CommandEnum[] listCmd = this.currentCommandMod.getListCommands();
		boolean isPresent=false;
		for(int i=0;i<listCmd.length;i++){
			if(listCmd[i].name().equals(cmd.toUpperCase()))
				isPresent=true;
		}*/
		return true;
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
	}


}

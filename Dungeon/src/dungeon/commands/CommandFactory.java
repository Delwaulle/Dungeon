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
	
	/**
	 * execute the command associate to the user input
	 * @param user input (command + args)
	 */
	public void interpretCommand(String [] cmd){
		if(isValidCommandWithMod(cmd[0])){

		}
		else{
			System.out.println("Non valid command, enter \"help\" to show all possibles commands");
		}
		
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

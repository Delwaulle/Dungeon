package dungeon.commands;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {

	private Map<String, Command> commands;
	
	public CommandFactory() {
		this.commands = new HashMap<String, Command>();
	}

	public Map<String, Command> getMap() {
		return commands;
	}

	public void setMap(Map<String, Command> commands) {
		this.commands = commands;
	}
	
	public void initCommand(){
		this.commands.put("describe", new DescribeCommand());
		this.commands.put("help", new HelpCommand());
		this.commands.put("inventory", new ShowInventoryCommand());
	}
	
	public void executeCommand(String key){
		if ( this.commands.containsKey(key) ) {
			this.commands.get(key).apply();
		}
	}

}

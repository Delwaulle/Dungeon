package dungeon.commands;


/**
 * @author Loic
 * Call the execute method of a command without the knowledge of this command
 */
public class CommandFactory {

	Command command;

	public CommandFactory(Command command) {
		this.command = command;
	}
	
	public CommandFactory(){}

	public void setCommand(Command command) {
		this.command = command;
	}

	public void invoke() {
		command.execute();
	}

}

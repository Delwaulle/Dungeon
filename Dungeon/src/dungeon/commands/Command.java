package dungeon.commands;

/**
 * @author Loïc
 * A command execute an action
 */
public interface Command {
	/**
	 * Execute the command 
	 */
	public void execute();
	
	/**
	 * @return the description of the command
	 */
	public String getDescription();
}

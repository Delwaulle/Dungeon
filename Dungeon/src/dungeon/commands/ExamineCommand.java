package dungeon.commands;

import dungeon.items.Furniture;

/**
 * @author Loic
 * 
 */
public class ExamineCommand implements Command{

	private Furniture furniture;
	private final String COMMAND_DESCRIPTION="examine : Examine a furniture which are in a room Ex : \"examine the carpet \"";
	
	/**
	 * @param furniture
	 */
	public ExamineCommand(Furniture furniture) {
		this.furniture=furniture;
	}
	
	@Override
	public void execute() {
		//
	}

	@Override
	public String getDescription() {
		return COMMAND_DESCRIPTION;
	}
}

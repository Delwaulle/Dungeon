package dungeon.commands;

import dungeon.items.Furniture;

/**
 * @author Loic
 * Launch the examination of the furniture
 */
public class ExamineCommand implements Command{

	private Furniture furniture;
	
	/**
	 * @param furniture
	 */
	public ExamineCommand(Furniture furniture) {
		this.furniture=furniture;
	}
	
	@Override
	public void execute() {
		this.furniture.examine();
	}

}

package dungeon.commands;

import dungeon.level.Room;

/**
 * @author Loic
 * This command asks the description of the room passed in param
 */
public class DescribeCommand implements Command{

	private Room currentRoom;
	private final String COMMAND_DESCRIPTION="Describe the room";
	
	/**
	 * @param room
	 */
	public DescribeCommand(Room room) {
		this.currentRoom=room;
	}
	
	@Override
	public void execute() {
		currentRoom.askDescription();
	}

	@Override
	public String getDescription() {
		return COMMAND_DESCRIPTION;
	}

}

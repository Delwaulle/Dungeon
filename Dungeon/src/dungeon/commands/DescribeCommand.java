package dungeon.commands;

import dungeon.level.Room;

/**
 * @author Loic
 * This command asks the description of the room passed in param
 */
public class DescribeCommand implements Command{

	private Room currentRoom;
	
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

}

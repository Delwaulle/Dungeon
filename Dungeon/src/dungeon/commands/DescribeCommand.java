package dungeon.commands;

import dungeon.level.Room;

public class DescribeCommand implements Command{

	private Room currentRoom;
	
	public DescribeCommand() {}
	
	public void setRoom(Room room){
		this.currentRoom = room;
	}

	@Override
	public void apply() {
		currentRoom.askDescription();
	}

}

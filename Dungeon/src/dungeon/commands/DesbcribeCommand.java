package dungeon.commands;

import dungeon.level.Room;

public class DesbcribeCommand implements Command{

	private Room currentRoom;
	
	public DesbcribeCommand() {}
	
	public void setRoom(Room room){
		this.currentRoom = room;
	}

	@Override
	public void apply() {
		if(currentRoom.getDescription() != null)
			System.out.println(currentRoom.getDescription());
		else
			System.out.println("There is no description for this room.");
	}

}

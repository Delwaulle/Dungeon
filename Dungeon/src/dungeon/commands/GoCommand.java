package dungeon.commands;

import dungeon.level.Direction;
import dungeon.level.Level;
import dungeon.level.Room;

/**
 * @author Loic
 * This command serves to travel from room to another room
 */
public class GoCommand implements Command{

	private Level level;
	private Direction direction;
	private String directionName;
	
	/**
	 * @param level
	 * @param direction
	 */
	public GoCommand(Level level,Direction direction){
		this.level = level;
		this.direction=direction;
		this.directionName=direction.name();
	}
	
	/**
	 * @param level
	 * @param directionName
	 */
	public GoCommand(Level level,String directionName){
		this.level = level;
		this.directionName=directionName;
	}

	@Override
	public void execute() {
		if(Direction.isValidDirectionEnum(directionName.toUpperCase())){
			direction=Direction.valueOf(directionName.toUpperCase());
			Room newRoom = level.getCurrentRoom().goToDirection(direction);
			if(newRoom!=null){
				level.setPreviousRoom(level.getCurrentRoom());
				level.setCurrentRoom(newRoom);
			}
			else
				System.out.println("No room in this direction");
		}
		else
			System.out.println("Bad Direction !");
		
	}
}

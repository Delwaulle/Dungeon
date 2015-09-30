package dungeon.commands;

import dungeon.level.Direction;
import dungeon.level.Level;
import dungeon.level.Room;

public class GoCommand implements Command{

	private Level level;
	private Direction direction;
	
	public GoCommand(Level level){
		this.level = level;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	@Override
	public void apply() {
		Room newRoom = level.getCurrentRoom().goToDirection(direction);
		if(newRoom!=null){
			level.setPreviousRoom(level.getCurrentRoom());
			level.setCurrentRoom(newRoom);
		}
		else
			System.out.println("Impossible action !");
		
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

}

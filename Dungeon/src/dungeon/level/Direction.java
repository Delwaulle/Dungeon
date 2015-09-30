package dungeon.level;

/**
 * Enum for all the possible directions in a room
 * @author Loic
 *
 */
public enum Direction {

	NORTH(1),
	EAST(2),
	SOUTH(3),
	WEST(4);
	
	private int id;
	
	/**
	 * @param id
	 */
	private Direction(int id){
		this.id=id;
	}
	
	/**
	 * @return the opposite of the current direction
	 */
	public Direction getOppositeDirection(){
		switch(this){
		case NORTH :
			return SOUTH;
		case WEST :
			return EAST;
		case EAST :
			return WEST;
		case SOUTH :
			return NORTH;
		default : return NORTH;
		}
	}
	
	
	/**
	 * @param value
	 * @return if the value is an element of the Direction's enum
	 */
	public static boolean isValidDirectionEnum(String value){
		for (Direction direction : values()) {
	        if(direction.name().equals(value))
	           return true;
	    }
	    return false;
	}
	
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}
	
}

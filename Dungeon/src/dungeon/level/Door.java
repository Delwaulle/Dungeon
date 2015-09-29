package dungeon.level;

/**
 * @author Loic
 * Represents the transition between two rooms
 * Can be in 3 states : normal,locked or hidden
 */
public class Door {
	
	protected String direction;
	protected boolean locked;
	protected boolean hidden;
	
	/**
	 * create a door with its direction
	 * @param direction
	 */
	public Door(String direction){
		this.direction=direction;
		this.locked=false;
		this.hidden=false;
	}
	
	/**
	 * @return the direction
	 */
	public String getDirection() {
		return direction;
	}

	/**
	 * set a direction for using the door
	 * @param direction
	 */
	public void setDirection(String direction) {
		this.direction = direction;
	}

	/**
	 * create a door, and we specify if it's locked or hidden
	 * @param direction
	 * @param hidden
	 * @param locked
	 */
	public Door(String direction,boolean hidden,boolean locked){
		this.direction=direction;
		this.hidden=hidden;
		this.locked=locked;
	}

	/**
	 * @return if the door is locked or not
	 */
	public boolean isLocked() {
		return locked;
	}

	/**
	 * lock a door
	 * @param locked
	 */
	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	/**
	 * @return if a door is hidden or not
	 */
	public boolean isHidden() {
		return hidden;
	}

	/**
	 * hide a door
	 * @param hidden
	 */
	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
}

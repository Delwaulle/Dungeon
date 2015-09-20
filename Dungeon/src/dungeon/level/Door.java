package dungeon.level;

public class Door {
	
	protected String direction;
	protected boolean locked;
	protected boolean hidden;
	
	public Door(String direction){
		this.direction=direction;
		this.locked=false;
		this.hidden=false;
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Door(String direction,boolean hidden,boolean locked){
		this.direction=direction;
		this.hidden=hidden;
		this.locked=locked;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	
	
	

}

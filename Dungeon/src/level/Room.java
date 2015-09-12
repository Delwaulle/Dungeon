package level;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
	public Map<String,Room> neighbours = new HashMap<>();	
	protected String name;
	
	public Room(String name){
		this.name=name;
	}
	
	public void setNeighbour(String direction, Room neighbour){
		neighbours.put(direction,neighbour);
	}
	public Room goToDirection(String direction){
		return (neighbours.containsKey(direction)) ? neighbours.get(direction) : null;
	}
	public String getName(){
		return this.name;
	}
	public abstract String getDescription();
	
	public abstract String getDirection();
}

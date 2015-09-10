package game;

import java.util.HashMap;
import java.util.Map;

public class Room {
	private final String name;
	private Map<String,Room> neighbours = new HashMap<String,Room>();
	
	public Room(String name){
		this.name=name;
	}
	
	public Room goToDirection(String direction){
		return (neighbours.containsKey(direction)) ? neighbours.get(direction) : null;
	}
	
	public void setNeighbour(String direction, Room neighbour){
		neighbours.put(direction,neighbour);
	}
	
	public String getName(){
		return this.name;
	}
}

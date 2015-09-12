package level;

import java.util.HashMap;
import java.util.Map;

public interface Room {
	public Map<String,Room> neighbours = new HashMap<String,Room>();	
	/*
	public Room goToDirection(String direction){
		return (neighbours.containsKey(direction)) ? neighbours.get(direction) : null;
	}
	
	public void setNeighbour(String direction, Room neighbour){
		neighbours.put(direction,neighbour);
	}
	
	public String getName(){
		return this.name;
	}*/
	
	public void setNeighbour(String direction, Room neighbour);
	public Room goToDirection(String direction);
	public String getName();
}

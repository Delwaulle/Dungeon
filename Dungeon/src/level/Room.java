package level;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Room {
	public Map<String,Room> neighbours = new HashMap<>();	
	protected String name, description;
	Scanner scanner = new Scanner(System.in);
	
	public Room(String name){
		this.name=name;
	}
	
	
	public void setNeighbour(String direction, Room neighbour){
		neighbours.put(direction,neighbour);
	}
	public Room goToDirection(String direction){
		if(neighbours.containsKey(direction)){
			Room nextRoom = neighbours.get(direction);
			return nextRoom;
		}
		else
			return null;
	}
	
	
	public String getName(){
		return this.name;
	}
	
	public abstract void setDescription(String description);
	
	public abstract String getDescription();
	
	public abstract String getDirection();
	
	public abstract void displayInformation();
	
	public abstract void action();
}

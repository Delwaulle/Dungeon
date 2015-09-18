package dungeon.level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dungeon.action.DecorAction;

public abstract class Room {
	protected Map<String,Room> neighbours = new HashMap<>();
	protected Map<String,DecorAction> decors = new HashMap<>();
	protected String name;
	protected Level level;
	Scanner scanner = new Scanner(System.in);
	
	public Room(String name,Level level){
		this.name=name;
		this.level=level;
	}
	
	public void setDecor(String name,DecorAction action){
		this.decors.put(name,action);
	}
	
	public void displayDirections(){
		System.out.println("Possible(s) direction(s) :");
		String directions="-- ";
		@SuppressWarnings("rawtypes")
		Set listKeys=this.neighbours.keySet();  // key list of the map
		@SuppressWarnings("rawtypes")
		Iterator iterateur=listKeys.iterator(); 
		while(iterateur.hasNext())
		{
			Object key= iterateur.next();
			directions+=key.toString()+" -- ";
		}
		System.out.println(directions);
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

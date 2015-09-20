package dungeon.level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dungeon.action.DecorAction;
import dungeon.game.GameBoard;

/**
 * @author Loïc
 *
 */

public abstract class Room {
	protected Map<Door,Room> neighbours = new HashMap<>();
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
			Door key= (Door)iterateur.next();
			directions+=key.getDirection().toString()+" -- ";
		}
		System.out.println(directions);
	}
	
	public void setNeighbour(Door door, Room neighbour){
		neighbours.put(door,neighbour);
	}
	public Room goToDirection(String direction){
		
		Door door = validDirection(direction); // test if the direction is possible
		if(door!=null){
			
			if(door.isLocked()){
				System.out.println("You need to find a key to open this door");
				if(GameBoard.player.getInventory().searchItem("key")==-1){
					System.out.println("Sorry you don't have the key to open this door, keep digging around this room");
					return null;
				}
				System.out.println("Good game you have found the key ! You discover a new room !");
			}
			if(door.isHidden()){
				System.out.println("you are a lucky guy you find an hidden door");
			}
			Room nextRoom = neighbours.get(door);
			return nextRoom;
		}
		else
			return null;
	}
	
	//for each Door we look at the direction
	public Door validDirection(String direction){
		for(Door door : neighbours.keySet()){
			if(door.getDirection().equals(direction))
				return door;
		}
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

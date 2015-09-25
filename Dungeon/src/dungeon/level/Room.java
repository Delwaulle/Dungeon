package dungeon.level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dungeon.action.DecorAction;
import dungeon.game.GameBoard;

/**
 * @author Lo�c
 *
 */

public abstract class Room {
	protected Map<Door,Room> neighbours = new HashMap<>();
	//protected Map<String,DecorAction> decors = new HashMap<>();
	protected String name;
	protected Level level;
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * construct a room with a name and the level which the room is inside
	 * @param name
	 * @param level
	 */
	public Room(String name,Level level){
		this.name=name;
		this.level=level;
	}
	
	/**
	 * set the decor of a room
	 * @param name
	 * @param action
	 */
	/*public void setDecor(String name,DecorAction action){
		this.decors.put(name,action);
	}*/
	
	/**
	 * We show to the player all the directions he can go now
	 */
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
	
	/**
	 * set a neighbor between two rooms
	 * @param door
	 * @param neighbour
	 */
	public void setNeighbour(Door door, Room neighbour){
		neighbours.put(door,neighbour);
	}
	/**
	 * @param direction
	 * @return the direction of the player
	 */
	public Room goToDirection(String direction){
		
		Door door = validDirection(direction,this.neighbours); // test if the direction is possible
		if(door!=null){
			
			if(door.isLocked()){
				if(GameBoard.player.getInventory().searchItem("key")==-1){
					System.out.println("Sorry you don't have the key to open this door, keep digging around this room");
					return null;
				}
				else{
					GameBoard.player.getInventory().useItem("key", 1);
					System.out.println("Good game you have the key to open this door ! You discover a new room !");
				}
			}
			if(door.isHidden()){
				System.out.println("you are a lucky guy you find an hidden door");
			}
			Room nextRoom = neighbours.get(door);
			
			//set the neighboor to back in the previous room
			String oppositeDirection=getOppositeDirection(direction);
			if(validDirection(oppositeDirection, nextRoom.neighbours)==null){
				nextRoom.setNeighbour(new Door(oppositeDirection), this);
			}
			return nextRoom;
		}
		else
			return null;
	}
	
	/**
	 * @param direction
	 * @return back up of the player
	 */
	public String getOppositeDirection(String direction){
		switch(direction){
		case "north" :
			return "south";
		case "west" :
			return "east";
		case "east" :
			return "west";
		case "south" :
			return "north";
		default : return "";
		}
	}
	
	/**
	 * for each Door we look at the direction
	 * @param direction
	 * @param directions
	 * @return
	 */
	public Door validDirection(String direction,Map<Door, Room> directions){
		for(Door door : directions.keySet()){
			if(door.getDirection().equals(direction))
				return door;
		}
		return null;
	}
	
	
	/**
	 * @return the name
	 */
	public String getName(){
		return this.name;
	}
	
	public abstract void setDescription(String description);
	
	public abstract String getDescription();
	
	public abstract String getDirection();
	
	public abstract void displayInformation();
	
	public abstract void action();
}

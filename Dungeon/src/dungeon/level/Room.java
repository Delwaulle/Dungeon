package dungeon.level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import dungeon.actions.ActionFactory;
import dungeon.game.GameBoard;
import dungeon.game.Player;
import dungeon.items.Item;

/**
 * Each elements which composed a level
 * It contains door(s),monster,treasoure and some actions with decor
 * @author Loic
 * 
 */

public abstract class Room {
	
	protected Map<Door,Room> neighbours = new HashMap<>();
	protected ActionFactory actions = new ActionFactory();
	protected String name;
	protected Level level;
	protected boolean isDescribed;
	Scanner scanner = new Scanner(System.in);
	protected Player player = GameBoard.player;
	
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
	 * We show to the player all the directions he can go now
	 */
	public void displayDirections(){
		System.out.println("Possible(s) direction(s) :");
		String directions="-- ";
		Set<Door> listKeys=this.neighbours.keySet();  // key list of the map
		Iterator<Door> iterateur=listKeys.iterator(); 
		while(iterateur.hasNext())
		{
			Door key= (Door) iterateur.next();
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
	public Room goToDirection(Direction direction){
		
		Door door = validDirection(direction,this.neighbours); // test if the direction is possible
		if(door!=null){
			
			if(door.isLocked()){
				if(!this.player.getInventory().isPresent(Item.SAMPLE_KEY)){
					System.out.println("Sorry you don't have the key to open this door, keep digging around this room");
					return null;
				}
				else{
					this.player.getInventory().useItem(Item.SAMPLE_KEY, 1);
					System.out.println("Good game you have the key to open this door ! You discover a new room !");
				}
			}
			if(door.isHidden()){
				System.out.println("you are a lucky guy you find an hidden door");
			}
			Room nextRoom = neighbours.get(door);
			
			//set the neighboor to back in the previous room
			Direction oppositeDirection=direction.getOppositeDirection();
			if(validDirection(oppositeDirection, nextRoom.neighbours)==null){
				nextRoom.setNeighbour(new Door(oppositeDirection), this);
			}
			return nextRoom;
		}
		else
			return null;
	}



	/**
	 * for each Door we look at the direction
	 * @param direction
	 * @param directions
	 * @return
	 */
	public Door validDirection(Direction direction,Map<Door, Room> directions){
		for(Door door : directions.keySet()){
			if(door.getDirection().equals(direction))
				return door;
		}
		return null;
	}
	
	/**
	 * If the player asks the description of the room :
	 * set the boolean isDescribed to true
	 * display all the objects in the room 
	 * show all actions possible with this objects
	 */
	public void askDescription(){
		this.isDescribed=true;
		System.out.println(this.actions.toString());
		
	}
	
	
	/**
	 * @return the name of the room
	 */
	public String getName(){
		return this.name;
	}
	
	
	/**
	 * @return if the player asks the description of the room
	 */
	public boolean isDescribed() {
		return isDescribed;
	}
	
	// ========================= ABSTRACT =======================
		
	/**
	 * @param description
	 */
	public abstract void setDescription(String description);
	
	
	/**
	 * @return the description of the room
	 */
	public abstract String getDescription();
	
	
	/**
	 * @return the direction
	 */
	public abstract String getDirection();
	
		
	/**
	 * Just display the informations of the room on the screen
	 */
	public abstract void displayInformation();
	
		
	/**
	 * Execute the action bind to the room
	 */
	public abstract void action();
	
	/**
	 * only used for tests
	 * @param player
	 */
	public void setPlayer(Player player){
		this.player = player;
	}
}

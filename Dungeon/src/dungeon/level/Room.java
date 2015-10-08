package dungeon.level;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import dungeon.items.Furniture;
import dungeon.commands.CommandFactory;
import dungeon.commands.Mod;
import dungeon.game.GameBoard;
import dungeon.game.Player;
import dungeon.items.Item;
import dungeon.utils.RandomGenerator;
import dungeon.utils.SecureInput;

/**
 * Each elements which composed a level
 * It contains door(s),monster,treasoure and some actions with decor
 * @author Loic
 * 
 */

public abstract class Room {
	
	protected Map<Door,Room> neighbours = new HashMap<>();
	protected List<Furniture> furnitures; //generate random pllls
	protected String name;
	protected Level level;
	protected boolean isDescribed;
	private CommandFactory commandFactory;
	protected Player player = GameBoard.player;
	
	/**
	 * construct a room with a name and the level which the room is inside
	 * @param name
	 * @param level
	 */
	public Room(String name,Level level){
		this.name=name;
		this.level=level;
		this.furnitures=RandomGenerator.generateRandomFurnitureList();
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
		if(isValidDirection(door.getDirection()))
			neighbours.put(door,neighbour);
	}
	
	/**
	 * @param direction
	 * @return if the direction not exist in the room
	 */
	public boolean isValidDirection(Direction direction){
		boolean valid =true;
		for(Door doorToCompare : this.neighbours.keySet()){
			if(doorToCompare.getDirection().equals(direction))
				valid=false;
		}
		return valid;
	}
	
	/**
	 * @param direction
	 * @return the direction of the player
	 */
	public Room goToDirection(Direction direction){
		
		Door door = validDirection(direction,this.neighbours); // test if the direction is possible
		if(door!=null){
			
			if(door.isLocked()){
				if(!this.player.getInventory().isPresent(Item.KEY)){
					System.out.println("Sorry you don't have the key to open this door, keep digging around this room");
					return null;
				}
				else{
					this.player.getInventory().useItem(Item.KEY);
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
		System.out.println("There are in this room : ");
		if(furnitures.size()==0){
			System.out.println("No furniture in this room !");
		}
		else{
			for (Furniture furniture : furnitures){
				System.out.println("- "+furniture.getFurniture().name());
			}
			this.commandFactory=new CommandFactory(Mod.EXCAVATION_MOD);
			System.out.println("Now you can examine the furnitures");
			examineFurniture();
		}
	}
	
	
	/**
	 * verify if the furniture to examine is correct and call the action associate with it 
	 */
	public void examineFurniture(){
		System.out.println("What do you want to do ? (Enter help to show all the possible commands)");
		System.out.print("> ");	
		String line = SecureInput.getNoEmptyStringInput();
		String[] cmd = line.split(" ",2);
	
		Furniture furniture=null;
		if(cmd.length!=1 && cmd[0].equals("examine")){
			for(Furniture f : furnitures){
				if(f.getFurniture().name().equals(cmd[1].toUpperCase()))
					furniture=f;
			}
			if(furniture==null){
				System.out.println("Invalid furniture, please try again");
				examineFurniture();
			}
		}
		if(!this.commandFactory.interpretCommand(cmd, this.player, this.level, this,null, furniture))
			this.examineFurniture();
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
	
	/**
	 * only used for tests
	 * @param player
	 */
	public void setPlayer(Player player){
		this.player = player;
	}
	
	// ========================= ABSTRACT =======================
		

		
	/**
	 * Just display the informations of the room on the screen
	 */
	public abstract void displayInformation();
	
		
	/**
	 * Execute the action bind to the room
	 */
	public abstract void action();
	

}

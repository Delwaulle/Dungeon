package dungeon.level;

import java.util.List;
import java.util.Scanner;

import dungeon.game.GameBoard;
import dungeon.item.Inventory;

/**
 * @author Lo�c
 *
 */
public class Level {

	protected Room entrance,intersection,trap,exit; //better enum
	protected List<Room> roomList;
	protected NormalRoom passage;
	protected TreasureRoom treasureRoom ;
	protected MonsterRoom monsterRoom;
	protected Room currentRoom;
	private Room previousRoom;
	protected boolean gameIsFinished=false;
	protected final Scanner scanner = new Scanner(System.in);
	
	/**
	 * construct a level
	 * @param numLevel
	 */
	public Level(int numLevel){
		initializeRooms2();
		this.currentRoom=entrance;
	}
	
	/**
	 * for the moment, we initialize some level with its rooms
	 */
	public void initializeRooms(){
		entrance= new NormalRoom("entrance",this);
		intersection= new NormalRoom("intersection",this);
		intersection.setDescription("There might be something weird on the left...");
		trap=new NormalRoom("trap",this);
		exit = new NormalRoom("exit",this);

		
		entrance.setNeighbour(new Door("north"), intersection);
		intersection.setNeighbour(new Door("north"), exit);
		intersection.setNeighbour(new Door("west"), trap);
	
	}
	
	/**
	 * for the moment, we initialize some level with its rooms
	 */
	public void initializeRooms2(){
		entrance = new NormalRoom("entrance",this);
		intersection = new NormalRoom("intersection",this);
		intersection.setDescription("2 ways, west or east. I can hear something strange on the east...");
		
		treasureRoom = new TreasureRoom("treasureroom",this);
		treasureRoom.setDescription("There is an empty chest on the ground.");
		
		monsterRoom = new MonsterRoom("monsterRoom",this);
		passage = new NormalRoom("passage",this);
		passage.setDescription("It turns to the north.");
		
		exit = new NormalRoom("exit",this);
		
		
		entrance.setNeighbour(new Door("north"), intersection);
		
		intersection.setNeighbour(new Door("west"), treasureRoom);
		intersection.setNeighbour(new Door("east"), monsterRoom);
		
		treasureRoom.setNeighbour(new Door("east"), intersection);
		
		monsterRoom.setNeighbour(new Door("west"), intersection);
		monsterRoom.setNeighbour(new Door("east"), passage);
		
		passage.setNeighbour(new Door("west"), monsterRoom);
		passage.setNeighbour(new Door("north"), exit);
	}
	
	
	/**
	 * @return the current room of the player
	 */
	public Room getCurrentRoom(){
		return this.currentRoom;
	}
	
	/**
	 * when the player go into the first room of the level
	 */
	public void goToEntrance(){
		this.currentRoom=entrance;
		this.displayMessage();
	}
	
	
	/**
	 * ask to the player what does he want to do ?
	 * @param command
	 */
	public void interpretCommand(String command){
		String[] cmd = command.split(" ",2);
		switch(cmd[0]){
		case "help":
			System.out.println("go : go to a direction. You must specify the direction. Ex: \"go north\"");
			System.out.println("describe :  describe you the room.");
			System.out.println("inventory :  shows your inventory.");
			break;
		
		case "go":
			Room newRoom = currentRoom.goToDirection(cmd[1]);
			if(newRoom!=null){
				this.previousRoom=currentRoom;
				currentRoom=newRoom;
			}
			else
				System.out.println("Impossible action !");
			break;
		
		case "describe":
			String roomDescription = currentRoom.getDescription();
			if(roomDescription == null)
				System.out.println("There is no description for this room.");
			else
				System.out.println(roomDescription);
			break;
			
		case "inventory":
			Inventory inventory = GameBoard.player.getInventory();
			System.out.println("Your inventory :");
			System.out.println(inventory);
			break;
			
		default:
			System.out.println("I don't know what you mean. Type \"help\" to show the differents commands.");
		}
	}

	/**
	 * ask for the player his choices
	 */
	public void displayMessage(){
		currentRoom.displayInformation();
		currentRoom.displayDirections();
		System.out.println("What do you want to do ?");
	}

	
	/**
	 * the buckle into which one the player is into for a level
	 * we give him the possible directions from his current room
	 * and we made it until he completes the level or loses the game 
	 * @throws InterruptedException
	 */
	public void start() throws InterruptedException{
		do{			
			displayMessage();
			currentRoom.action();
			System.out.println("> ");
			
			//Read a command from the player
			String line = this.scanner.nextLine();
			interpretCommand(line);				
		}while(!gameIsFinished());
		
		System.out.println("You are in "+getCurrentRoom().getName());
		if(gameIsWon()){
			Thread.sleep(500);
			System.out.println("You win !");
			Thread.sleep(1000);
		}
		else
			System.out.println("You loose !");
		
	}
	
	/**
	 * @return if the player lose or win
	 */
	public boolean gameIsFinished(){
		return gameIsLose() || gameIsWon();
	}

	/**
	 * @return the win when the player has finished the level
	 */
	public boolean gameIsWon() {
		return currentRoom.getName().equals("exit");
	}
	
	/**
	 * @return the lose when the player is dead or in a trap
	 */
	public boolean gameIsLose() {
		return currentRoom.getName().equals("trap");
	}

	/**
	 * if the player wants to go back
	 */
	public void goToPreviousRoom(){
		this.currentRoom=previousRoom;
		this.displayMessage();
	}
}

package dungeon.level;

import java.util.List;
import java.util.Scanner;

import dungeon.game.*;

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
	
	public Level(){
		initializeRooms2();
		this.currentRoom=entrance;
	}
	
	public void initializeRooms(){
		entrance= new NormalRoom("entrance",this);
		intersection= new NormalRoom("intersection",this);
		intersection.setDescription("There might be something weird on the left...");
		trap=new NormalRoom("trap",this);
		exit = new NormalRoom("exit",this);

		
		entrance.setNeighbour("north", intersection);
		intersection.setNeighbour("north", exit);
		intersection.setNeighbour("west", trap);
	
	}
	
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
		
		
		entrance.setNeighbour("north", intersection);
		
		intersection.setNeighbour("west", treasureRoom);
		intersection.setNeighbour("east", monsterRoom);
		
		treasureRoom.setNeighbour("east", intersection);
		
		monsterRoom.setNeighbour("west", intersection);
		monsterRoom.setNeighbour("east", passage);
		
		passage.setNeighbour("west", monsterRoom);
		passage.setNeighbour("north", exit);
	}
	
	
	public Room getCurrentRoom(){
		return this.currentRoom;
	}
	
	public void goToEntrance(){
		this.currentRoom=entrance;
		this.displayMessage();
	}
	
	
	public void interpretCommand(String command){
		String[] cmd = command.split(" ",2);
		switch(cmd[0]){
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
			System.out.println("I don't know what you mean");
		}
	}

	public void displayMessage(){
		currentRoom.displayInformation();
		currentRoom.displayDirections();
		System.out.println("What do you want to do ?");
	}

	
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
	
	public boolean gameIsFinished(){
		return gameIsLose() || gameIsWon();
	}

	public boolean gameIsWon() {
		return currentRoom.getName().equals("exit");
	}
	
	public boolean gameIsLose() {
		return currentRoom.getName().equals("trap");
	}

	public void goToPreviousRoom(){
		this.currentRoom=previousRoom;
		this.displayMessage();
	}
}

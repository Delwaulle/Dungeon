package dungeon.level;

import java.util.List;
import java.util.Scanner;

import dungeon.commands.*;
import dungeon.game.GameBoard;

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
		//initializeRooms3(numLevel);
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
	 * for the moment, we initialize some level with its rooms
	 */
	public void initializeRooms3(int numLevel){
		// create the entrance
		entrance = new NormalRoom("entrance",this);
		
		int nbNormalRoom=numLevel*(1/2)+2;
		int nbMonsterRoom=numLevel*(1/5)+1;
		int nbTreasureRoom=numLevel*(1/6)+1;
		
		int totalNumberOfRoom = nbMonsterRoom+nbNormalRoom+nbTreasureRoom;
		int r;
		while(totalNumberOfRoom!=0){
			r = (int) (10*Math.random());
			while(r!=1 || r!=2 ||r!=3){
				r = (int) (10*Math.random());
			}
			if(r==1 && nbNormalRoom!=0){
				nbNormalRoom--;
			}else if(r==2 && nbMonsterRoom!=0){
				nbMonsterRoom--;
			}else if(r==3 && nbTreasureRoom!=0){
				nbTreasureRoom--;
			}
			totalNumberOfRoom = nbMonsterRoom+nbNormalRoom+nbTreasureRoom;
		}
		
		
		intersection = new NormalRoom("intersection",this);
		intersection.setDescription("2 ways, west or east. I can hear something strange on the east...");
		
		treasureRoom = new TreasureRoom("treasureroom",this);
		treasureRoom.setDescription("There is an empty chest on the ground.");
		
		monsterRoom = new MonsterRoom("monsterRoom",this);
		passage = new NormalRoom("passage",this);
		passage.setDescription("It turns to the north.");
		//create the exit
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
			GameBoard.commandFactory.executeCommand("help");
			break;
		
		case "go":
			GoCommand goCom = (GoCommand) GameBoard.commandFactory.getMap().get("go");
			goCom.setDirection(cmd[1]);
			goCom.apply();
			break;
		
		case "describe":
			DescribeCommand describeCom = (DescribeCommand) GameBoard.commandFactory.getMap().get("describe");
			describeCom.setRoom(this.currentRoom);
			describeCom.apply();
			break;
			
		case "inventory":
			GameBoard.commandFactory.executeCommand("inventory");
			break;
			
		case "use":
			//ConsumeHealPotionCommand consumeCommand = (ConsumeHealPotionCommand) GameBoard.commandFactory.getMap().get("use");
			//consumeCommand.setPotion((Potion) GameBoard.player.getInventory().getItem(cmd[1]));
			//consumeCommand.apply();
			break;
			
		case "stats":
			GameBoard.commandFactory.executeCommand("stats");
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
	
	public Room getPreviousRoom(){
		return this.previousRoom;
	}
	
	public void setPreviousRoom(Room room){
		this.previousRoom = room;
	}
	
	public void setCurrentRoom(Room room){
		this.currentRoom = room;
	}
}

package dungeon.level;

import java.util.List;

import dungeon.commands.*;
import dungeon.game.GameBoard;
import dungeon.items.Item;
import dungeon.utils.SecureInput;

/**
 * @author Loic
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

		
		entrance.setNeighbour(new Door(Direction.NORTH), intersection);
		intersection.setNeighbour(new Door(Direction.NORTH), exit);
		intersection.setNeighbour(new Door(Direction.WEST), trap);
	
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
		
		
		entrance.setNeighbour(new Door(Direction.NORTH), intersection);
		
		intersection.setNeighbour(new Door(Direction.WEST), treasureRoom);
		intersection.setNeighbour(new Door(Direction.EAST), monsterRoom);
		
		treasureRoom.setNeighbour(new Door(Direction.EAST), intersection);
		
		monsterRoom.setNeighbour(new Door(Direction.WEST), intersection);
		monsterRoom.setNeighbour(new Door(Direction.EAST), passage);
		
		passage.setNeighbour(new Door(Direction.WEST), monsterRoom);
		passage.setNeighbour(new Door(Direction.NORTH), exit);
	}
	
	/**
	 * for the moment, we initialize some level with its rooms
	 */
	public void initializeRooms3(int numLevel){
		// create the entrance
		entrance = new NormalRoom("entrance",this);
		
		intersection = new NormalRoom("intersection",this);
		//intersection.setDescription("2 ways, west or east. I can hear something strange on the east...");
		
		treasureRoom = new TreasureRoom("treasureroom",this);
		treasureRoom.setDescription("There is an empty chest on the ground.");
		
		monsterRoom = new MonsterRoom("monsterRoom",this);
		passage = new NormalRoom("passage",this);
		passage.setDescription("It turns to the north.");
		//create the exit
		exit = new NormalRoom("exit",this);
		
		int nbNormalRoom=numLevel*(1/2)+2;
		int nbMonsterRoom=numLevel*(1/5)+1;
		int nbTreasureRoom=numLevel*(1/6)+1;
		
		int totalNumberOfRoom = nbMonsterRoom+nbNormalRoom+nbTreasureRoom+1;//+the entrance
		int roomsLeft=totalNumberOfRoom;
		int aRandomRoom;
		Direction direction;
		Object currentRoom=null;
		Object nextRoom = null;
		
		//create different random room from another random room
		while(roomsLeft!=0){
			aRandomRoom = generateARoom();
			direction = generateADireciton();
			while(aRandomRoom!=1 || aRandomRoom!=2 ||aRandomRoom!=3){
				aRandomRoom = generateARoom();
			}
			if(totalNumberOfRoom==roomsLeft){
				currentRoom=entrance;
			}
			if(aRandomRoom==1 && nbNormalRoom!=0){
				nextRoom=intersection;
				nbNormalRoom--;
			}else if(aRandomRoom==2 && nbMonsterRoom!=0){
				nextRoom=monsterRoom;
				nbMonsterRoom--;
			}else if(aRandomRoom==3 && nbTreasureRoom!=0){
				nextRoom=treasureRoom;
				nbTreasureRoom--;
			}
			if(roomsLeft==1){
				nextRoom=exit;
			}
			((Room) currentRoom).setNeighbour(new Door(direction), (Room)nextRoom);
			currentRoom=nextRoom;
			roomsLeft = nbMonsterRoom+nbNormalRoom+nbTreasureRoom;
		}
		
	}
	
	
	private Direction generateADireciton() {
		return Direction.NORTH;
	}

	/** generate an int which equals to normalRoom or monsterRoom or treasureRoom
	 * @return an int between 1, 2 and 3 
	 */
	private int generateARoom() {
		int r = (int) (10*Math.random());
		while(r!=1 || r!=2 ||r!=3){
			r = (int) (10*Math.random());
		}
		return r;
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
			if(Direction.isValidDirectionEnum(cmd[1].toUpperCase())){
				goCom.setDirection(Direction.valueOf(cmd[1].toUpperCase()));
				goCom.apply();
			}
			else
				System.out.println("Bad direction");
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
		
		case "equip":
			EquipPrimaryWeaponCommand equipCommand = (EquipPrimaryWeaponCommand) GameBoard.commandFactory.getMap().get("equip");
			if(Item.isValidItemEnum(cmd[1].toUpperCase()) && GameBoard.player.getInventory().isPresent(Item.valueOf(cmd[1].toUpperCase()))){
				Item item=GameBoard.player.getInventory().getItemByType(Item.valueOf(cmd[1].toUpperCase())).getType();
				equipCommand.setWeapon(item);
				equipCommand.apply();
			} else {
				System.out.println("There is no \"" + cmd[1] + "\" in your inventory. Check if it's the good name, or check your inventory.");
			}
			break;
			
		case "stats":
			GameBoard.commandFactory.executeCommand("stats");
			break;
		case "drop":
			//an item
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
			System.out.print("> ");
			
			//Read a command from the player
			String line = SecureInput.getNoEmptyStringInput();
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
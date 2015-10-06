package dungeon.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dungeon.commands.*;
import dungeon.game.GameBoard;
import dungeon.game.Player;
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
	protected TrapRoom trapRoom;
	protected MonsterRoom monsterRoom;
	protected Room currentRoom;
	private Room previousRoom;
	protected boolean gameIsFinished=false;
	private Player player=GameBoard.player;
	private CommandFactory commandFactory=GameBoard.commandFactory;
	
	/**
	 * construct a level
	 * @param numLevel
	 */
	public Level(int numLevel){
		generateLevel(numLevel);
		this.currentRoom=entrance;
	}
	
	
	/**
	 * for the moment, we initialize some level with its rooms
	 */
	public void generateLevel(int numLevel){
		// create the entrance
		entrance = new NormalRoom("entrance",this);
		
		intersection = new NormalRoom("intersection",this);
		//intersection.setDescription("2 ways, west or east. I can hear something strange on the east...");
		
		treasureRoom = new TreasureRoom("treasureroom",this);
		treasureRoom.setDescription("There is an empty chest on the ground.");
		trapRoom = new TrapRoom("trapRoom",this);
		monsterRoom = new MonsterRoom("monsterRoom",this);
		passage = new NormalRoom("passage",this);
		passage.setDescription("It turns to the north.");
		//create the exit
		exit = new NormalRoom("exit",this);
		
		int nbNormalRoom=numLevel*(1/2)+2;
		int nbMonsterRoom=numLevel*(1/5)+1;
		int nbTreasureRoom=numLevel*(1/6)+1;
		int nbTrapRoom=numLevel*(1/6)+1;
		
		int totalNumberOfRoom = nbMonsterRoom+nbNormalRoom+nbTreasureRoom+nbTrapRoom+1;//+the entrance
		int roomsLeft=totalNumberOfRoom;
		int aRandomRoom;
		Direction direction;
		Direction lastDirection = null;
		Object currentRoom=null;
		Object nextRoom = null;
		int nbDoor;
		List <Direction> listDirections = new ArrayList<Direction>();
		//change the direction and move to RandomLevel
		//create different random room from another random room
		while(roomsLeft>0){
			listDirections.clear();
			listDirections.add(lastDirection);
			nbDoor = generateNbDoor();
			// for each door of the current room, we set a room
			for(int i=0;i<nbDoor;i++){
				
				aRandomRoom = generateARoom();
				System.out.println("room generated : " + aRandomRoom );
				direction = generateADirection(listDirections);
				lastDirection=oppositeDirection(direction);
				listDirections.add(direction);
				System.out.println("direction generated : " + direction);
				if(totalNumberOfRoom==roomsLeft){
					currentRoom=entrance;
				}
				if(aRandomRoom==1 && nbNormalRoom!=0){
					nextRoom=intersection;
					nbNormalRoom--;
				}else if(aRandomRoom==2 && nbMonsterRoom!=0){
					nbMonsterRoom--;
				}else if(aRandomRoom==3 && nbTreasureRoom!=0){
					nbTreasureRoom--;
				}else if(aRandomRoom==4 && nbTrapRoom!=0){
					nbTrapRoom--;
					System.out.println("trap room");
				}
				if(roomsLeft==1){
					nextRoom=exit;
					roomsLeft=0;
				}
				((Room) currentRoom).setNeighbour(new Door(direction), (Room)nextRoom);
				roomsLeft = nbMonsterRoom+nbNormalRoom+nbTreasureRoom+nbTrapRoom;
				
			}
			currentRoom=nextRoom;
		}
		
	}
	
	
	private Direction oppositeDirection(Direction direction) {
		return direction.getOppositeDirection();
	}


	private Direction generateADirection(List<Direction> listDirections) {
		Direction newDirection;
		int dir;
		do{
			Random r = new Random();
			dir = r.nextInt(4);
			newDirection = Direction.values()[dir];
		}while(listDirections.contains(newDirection));
		return newDirection;
	}

	private int generateNbDoor() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int nbDoor = r.nextInt(3)+1;
		return nbDoor;
	}
	
	/** generate an int which equals to normalRoom or monsterRoom or treasureRoom
	 * @return an int between 1, 2 and 3 
	 */
	private int generateARoom() {
		Random r = new Random();
		return r.nextInt(4)+1;
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
			commandFactory.setCommand(new HelpCommand());
			commandFactory.invoke();
			break;
		
		case "go":
			String directionName="";
			if(cmd.length!=2)
				directionName=" ";
			else
				directionName=cmd[1];
			commandFactory.setCommand(new GoCommand(this,directionName));			
			commandFactory.invoke();
			break;
		
		case "describe":
			commandFactory.setCommand(new DescribeCommand(this.currentRoom));
			commandFactory.invoke();
			break;
			
		case "inventory":
			commandFactory.setCommand(new ShowInventoryCommand(this.player));
			commandFactory.invoke();
			break;
			
		case "use":
			String potionName="";
			if(cmd.length!=2)
				potionName=" ";
			else
				potionName=cmd[1];
			commandFactory.setCommand(new ConsumeHealPotionCommand(this.player,potionName));
			commandFactory.invoke();

			break;
		
		case "equip":
			String equipName="";
			if(cmd.length!=2)
				equipName=" ";
			else
				equipName=cmd[1];
			commandFactory.setCommand(new EquipItemCommand(this.player,equipName));
			commandFactory.invoke();

			break;
			
		case "stats":
			commandFactory.setCommand(new StatsCommand(this.player));	
			commandFactory.invoke();
			break;
		case "drop":
			String itemName;
			if(cmd.length!=2)
				itemName=" ";
			else
				itemName=cmd[1];
			commandFactory.setCommand(new DropCommand(this.player,itemName));
			commandFactory.invoke();
			break;	
		default:
			System.out.println("I don't know what you mean. Type \"help\" to show the differents commands.");
		}
	}

	/**
	 * ask for the player his choices
	 */
	public void displayMessage(){
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
			currentRoom.displayInformation();
			currentRoom.action();
			displayMessage();
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
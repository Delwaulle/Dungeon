package dungeon.level;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dungeon.commands.*;
import dungeon.game.GameBoard;
import dungeon.game.Player;
import dungeon.utils.RandomGenerator;
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
	private CommandFactory commandFactory;
	private int numLevel;
	
	/**
	 * construct a level
	 * @param numLevel
	 */
	public Level(int numDungeon, int numLevel){
		this.numLevel=numLevel;
		generateLevel(numDungeon,numLevel);
		this.currentRoom=entrance;
	}
	
	/**
	 * generate all the levels of all the dungeons
	 * @param numDungeon
	 * @param numLevel
	 */
	public void generateLevel(int numDungeon,int numLevel){
		// create the entrance
		
		entrance = new NormalRoom("entrance",this);
		
		intersection = new NormalRoom("intersection",this);
		//intersection.setDescription("2 ways, west or east. I can hear something strange on the east...");
		
		treasureRoom = new TreasureRoom("treasureroom",this);
		trapRoom = new TrapRoom("trapRoom",this);
		monsterRoom = new MonsterRoom("monsterRoom",this);
		passage = new NormalRoom("passage",this);
		//create the exit
		exit = new NormalRoom("exit",this);
		//give a prorata for each type of room in a level
		int nbNormalRoom=numDungeon*numLevel*(1/2)+2;
		int nbMonsterRoom=numDungeon*numLevel*(1/5)+1;
		int nbTreasureRoom=numDungeon*numLevel*(1/6)+1;
		int nbTrapRoom=numDungeon*numLevel*(1/6)+1;
		//the total number of rooms we have to create
		int totalNumberOfRoom = nbMonsterRoom+nbNormalRoom+nbTreasureRoom+nbTrapRoom;//+the entrance
		// the number of rooms left that we have to create
		int roomsLeft=totalNumberOfRoom;
		int aRandomRoom;
		Direction direction = null;
		Direction lastDirection = null;
		Room currentRoom=null;
		Room nextRoom = null;
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
				//System.out.println("room generated : " + aRandomRoom );
				direction = generateADirection(listDirections);
				listDirections.add(direction);
				//System.out.println("direction generated : " + direction);
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
				}else if(aRandomRoom==4 && nbTrapRoom!=0){
					nextRoom=trapRoom;
					nbTrapRoom--;
				}
				if(roomsLeft==1){
					nextRoom=exit;
					roomsLeft=0;
				}
				currentRoom.setNeighbour(new Door(direction),nextRoom);
				roomsLeft = nbMonsterRoom+nbNormalRoom+nbTreasureRoom+nbTrapRoom;
				
			}
			lastDirection=oppositeDirection(direction);

			currentRoom=nextRoom;
		}
		
	}
	
	
	/**
	 * @param direction
	 * @return the opposite direction
	 */
	private Direction oppositeDirection(Direction direction) {
		return direction.getOppositeDirection();
	}


	/**
	 * @param listDirections
	 * @return a random direction which is not in the listDirections
	 */
	private Direction generateADirection(List<Direction> listDirections) {
		Direction newDirection;
		do{
			newDirection = RandomGenerator.generateRandomDirection();
		}while(listDirections.contains(newDirection));
		return newDirection;
	}

	/**
	 * @return a number of Door for this room
	 */
	private int generateNbDoor() {
		// TODO Auto-generated method stub
		Random r = new Random();
		int nbDoor = r.nextInt(2)+1;
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
		this.currentRoom.displayDirections();
	}
	
	/**
	 * ask for the player his choices
	 */
	public void displayMessage(){
		currentRoom.displayDirections();
		System.out.println("What do you want to do ? (Enter help to show all the possible commands)");
		System.out.print("> ");	
	}

	/**
	 * read the command from the player
	 */
	public void readCommand(){
		this.commandFactory=new CommandFactory(Mod.BASIC_MOD);
		//this.commandFactory.showPossibleCommand();
		displayMessage();		
		//Read a command from the player
		String line = SecureInput.getNoEmptyStringInput();
		String[] cmd = line.split(" ",2);
		
		if(!this.commandFactory.interpretCommand(cmd, this.player, this, this.currentRoom, null, null))
			this.readCommand();
		
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
			readCommand();
		}while(!gameIsWon());
		
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
	 * @return the win when the player has finished the level
	 */
	public boolean gameIsWon() {
		return currentRoom.getName().equals("exit");
	}
	

	/**
	 * if the player wants to go back
	 */
	public void goToPreviousRoom(){
		this.currentRoom=previousRoom;
	}
	
	
	/**
	 * @return number of the level
	 */
	public int getNumLevel() {
		return numLevel;
	}
	
	/**
	 * @return the previous room
	 */
	public Room getPreviousRoom(){
		return this.previousRoom;
	}
	
	/**
	 * @param room
	 */
	public void setPreviousRoom(Room room){
		this.previousRoom = room;
	}
	
	/**
	 * @param room
	 */
	public void setCurrentRoom(Room room){
		this.currentRoom = room;
	}
}
package game;

import java.util.Scanner;

import level.*;

public class Dungeon {

		protected Room currentRoom;
		protected boolean gameIsFinished=false;
		protected final Scanner scanner = new Scanner(System.in);
		protected Player player;
		
		public Room getCurrentRoom(){
			return this.currentRoom;
		}
		
		public Dungeon(Level level,Player player){
			this.currentRoom=level.getEntrance();
			this.player=player;
		}
		
		public void interpretCommand(String command){
			String[] cmd = command.split(" ",2);
			switch(cmd[0]){
			case "go":
				Room newRoom = currentRoom.goToDirection(cmd[1]);
				if(newRoom!=null)
					currentRoom=newRoom;
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
				
			default:
				System.out.println("I don't know what you mean");
			}
		}

		
		public void start() throws InterruptedException{
			do{
				Thread.sleep(500);
				System.out.println("You are in "+getCurrentRoom().getName());
				Thread.sleep(500);
				System.out.println("What do you want to do ?");
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
}

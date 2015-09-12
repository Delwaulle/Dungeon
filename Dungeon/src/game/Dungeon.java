package game;

import java.util.Scanner;

import level.*;

public class Dungeon {

		private int level=1;
		protected Room currentRoom;
		protected boolean gameIsFinished=false;
		protected final Scanner scanner = new Scanner(System.in);
		
		public Room getCurrentRoom(){
			return this.currentRoom;
		}
		
		public Dungeon(Level level){
			this.currentRoom=level.getEntrance();
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
			default:
				System.out.println("I don't know what you mean");
			}
		}
		
		public static void main(String args[]){
			Dungeon dungeon = new Dungeon(new Level1());
			dungeon.start();
			/*Player p = new Player("Loic");       ===> test 
			p.getInventory().addItem(new Potion("Sword"), 2);
			p.getInventory().addItem(new Weapon("Sword"), 2);
			System.out.println(p.getInventory().toString());*/
		}
		
		public void start(){
			do{
				System.out.println("You are in "+getCurrentRoom().getName());
				System.out.println("What do you want to do ?");
				System.out.println("> ");
				
				//Read a command from the player
				String line = this.scanner.nextLine();
				interpretCommand(line);				
			}while(!gameIsFinished());
			
			System.out.println("You are in "+getCurrentRoom().getName());
			if(gameIsWon())
				System.out.println("You win !");
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

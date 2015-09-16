package game;

import java.util.Scanner;

import level.Level1;

public class GameBoard {

	public static int nbLevel=10;
	private Scanner scanner = new Scanner(System.in);
	public static Player player;
	
	public GameBoard() throws InterruptedException{
		
		System.out.println("Welcome to the game of dungeons");
		System.out.println("Choose a name for your player : \n>");
		String pseudo = scanner.nextLine();
		player = new Player(pseudo);
		System.out.println("Here is your departure's inventory");
		System.out.println(player.getInventory().toString());
		
		pressAnyKeyToContinue();
		
		for(int i =1;i<=nbLevel;i++){
			System.out.println("Welcome to the dungeon "+i);
			Dungeon dungeon = new Dungeon(new Level1());
			dungeon.start();
		}
	}
	
	 private void pressAnyKeyToContinue()
	 { 
	        System.out.println("Press Enter to start the adventure !");
	        try
	        {
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	        scanner.nextLine();
	 }

	public static void main(String args[]) throws InterruptedException{
		new GameBoard();
	}
}

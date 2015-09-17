package dungeon.game;

import java.util.Scanner;

import dungeon.level.*;

public class GameBoard {

	public static int nbLevel=1;
	private Scanner scanner = new Scanner(System.in);
	public static Player player;
	private Level[] levels;
	
	public GameBoard() throws InterruptedException{
		
		levels = new Level[nbLevel];
		levels[0] = new Level2();
		//levels[1] = new Level2();
		
		System.out.println("Welcome to the game of dungeons");
		System.out.println("Choose a name for your player : \n>");
		String pseudo = scanner.nextLine();
		player = new Player(pseudo);
		System.out.println("Here is your departure's inventory");
		System.out.println(player.getInventory().toString());
		
		pressAnyKeyToContinue();
		
		for(int i =0;i<nbLevel;i++){
			System.out.println("Welcome to the dungeon "+(i+1));
			Dungeon dungeon = new Dungeon(levels[i]);
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

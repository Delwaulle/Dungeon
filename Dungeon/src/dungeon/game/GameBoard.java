package dungeon.game;

import java.util.Scanner;

import dungeon.commands.CommandFactory;
import dungeon.commands.EquipPrimaryWeaponCommand;
import dungeon.commands.StatsCommand;


/**
 * @author fguilbert
 * the beginning of the game
 * The player can choose his pseudo
 * The inventory of the player is initialize and the dungeon 1 is instantiate
 */
public class GameBoard {
	
	public static int nbDungeon=1;
	private Scanner scanner = new Scanner(System.in);
	public static Player player;
	public static CommandFactory commandFactory;
	
	/**
	 * the beginning of the adventure for the player
	 * @throws InterruptedException
	 */
	public GameBoard() throws InterruptedException{
		System.out.println("Welcome to the game of dungeons");
		System.out.print("Choose a name for your player :\n> ");
		String pseudo ="NO_NAME";
		while(scanner.nextLine().equals(""))
			pseudo = scanner.nextLine();
		player = new Player(pseudo);
		commandFactory = new CommandFactory();
		commandFactory.initCommand();
		commandFactory.getMap().put("stats", new StatsCommand(player));
		commandFactory.getMap().put("equip", new EquipPrimaryWeaponCommand(player));
		System.out.println("Here is your departure's inventory");
		System.out.println(player.getInventory().toString());
		
		pressAnyKeyToContinue();
		
		for(int i =0;i<nbDungeon;i++){
			System.out.println("Welcome to the dungeon "+(i+1));
			Dungeon dungeon = new Dungeon();
			dungeon.start();
		}
	}
	
	 /**
	 * the system is waiting for a player's action
	 */
	private void pressAnyKeyToContinue(){ 
	        System.out.println("Press Enter to start the adventure !");
	        try{
	            System.in.read();
	        }  
	        catch(Exception e)
	        {}  
	        scanner.nextLine();
	 }

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException{
		new GameBoard();
	}
}

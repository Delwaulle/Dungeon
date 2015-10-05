package dungeon.game;

import java.util.Scanner;

import dungeon.commands.CommandFactory;
import dungeon.commands.Mod;
import dungeon.utils.Constants;
import dungeon.utils.LoadProperties;
import dungeon.utils.SecureInput;


/**
 * The beginning of the game
 * The player can choose his pseudo
 * The inventory of the player is initialize and the dungeon 1 is instantiate
 * @author fguilbert
 *
 */
public class GameBoard {
	
	private  int nbDungeon=Constants.MAX_DUNGEONS;
	private Scanner scanner = new Scanner(System.in);
	public static Player player;
	public static CommandFactory commandFactory=new CommandFactory(Mod.BASIC_MOD);
	
	/**
	 * the beginning of the adventure for the player
	 * @throws InterruptedException
	 */
	public GameBoard() throws InterruptedException{
		System.out.println("Welcome to the game of dungeons");
		System.out.print("Choose a name for your player :\n> ");
		String pseudo =SecureInput.getNoEmptyStringInput();
		player = new Player(pseudo);
		System.out.println("Here is your departure's inventory");
		System.out.println(player.getInventory().toString());
		
		pressAnyKeyToContinue();
		
		for(int i =0;i<nbDungeon;i++){
			System.out.println("Welcome to the dungeon "+(i+1));
			System.out.println("Enter 'help' for knowing all your possibilities.");
			Dungeon dungeon = new Dungeon();
			dungeon.start();
			System.out.println("========= NEXT DUNGEON ==========");
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
		new LoadProperties();
		new GameBoard();
	}
}

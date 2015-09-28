package dungeon.game;

import java.util.Map;
import java.util.Scanner;

import dungeon.commands.Command;
import dungeon.commands.GoCommand;
import dungeon.level.*;

/**
 * @author fguilbert
 * all the components of a dungeon
 */
public class Dungeon {

		protected Level currentLevel;
		protected boolean gameIsFinished=false;
		protected final Scanner scanner = new Scanner(System.in);
		private Level[] levels;
		public static int nbLevel=1;
		
		/**
		 * Initialize all the levels in the dungeon
		 * @throws InterruptedException
		 */
		public Dungeon() throws InterruptedException{
			levels = new Level[nbLevel];
			for(int i=0;i<levels.length;i++){
				levels[i]=new Level(i+1);
			}
		}
		
		/**
		 * the scenario of the dungeon
		 * all the levels which compose the dungeon
		 * @throws InterruptedException
		 */
		public void start() throws InterruptedException{
			for(int i =0;i<nbLevel;i++){
				System.out.println("Welcome to the level "+(i+1));
				Level level = levels[i];
				this.currentLevel=level;
				Map<String, Command> commandMap = GameBoard.commandFactory.getMap();
				GoCommand goCommand = new GoCommand(level);
				commandMap.put("go", goCommand);
				level.start();
				System.out.println("again");
			}
		}
		
		/**
		 * @return the current level
		 */
		public Level getCurrentLevel(){
			return this.currentLevel;
		}
	
}

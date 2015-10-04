package dungeon.game;

import dungeon.level.*;
import dungeon.utils.Constants;

/**
 * all the components of a dungeon
 * @author fguilbert
 * 
 */
public class Dungeon {

		protected Level currentLevel;
		protected boolean gameIsFinished=false;
		private Level[] levels;
		private int nbLevel=Constants.MAX_LEVELS;
		
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
				GameBoard.player.setCurrentLevel(level);
				this.currentLevel=level;
				level.start();
				System.out.println("========= NEXT LEVEL ==========");
			}
		}
		
		/**
		 * @return the current level
		 */
		public Level getCurrentLevel(){
			return this.currentLevel;
		}
	
}

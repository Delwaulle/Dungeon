package dungeon.game;

import java.util.Scanner;

import dungeon.level.*;

public class Dungeon {

		protected Level currentLevel;
		protected boolean gameIsFinished=false;
		protected final Scanner scanner = new Scanner(System.in);
		private Level[] levels;
		public static int nbLevel=1;
		
		public Dungeon() throws InterruptedException{
			levels = new Level[nbLevel];
			for(int i=0;i<levels.length;i++){
				levels[i]=new Level();
			}
						

		}
		
		public void start() throws InterruptedException{
			for(int i =0;i<nbLevel;i++){
				System.out.println("Welcome to the level "+(i+1));
				Level level = levels[i];
				this.currentLevel=level;
				level.start();
				System.out.println("again");
			}
		}
		
		public Level getCurrentLevel(){
			return this.currentLevel;
		}
	
}

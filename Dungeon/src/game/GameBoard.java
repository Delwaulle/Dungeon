package game;

import level.Level1;

public class GameBoard {

	private static int nbLevel=10;
	
	public static void main(String args[]) throws InterruptedException{
		
		for(int i =1;i<=nbLevel;i++){
			System.out.println("Welcome to the level "+i);
			Dungeon dungeon = new Dungeon(new Level1());
			dungeon.start();
			/*Player p = new Player("Loic");       ===> test 
			p.getInventory().addItem(new Potion("Sword"), 2);
			p.getInventory().addItem(new Weapon("Sword"), 2);
			System.out.println(p.getInventory().toString());*/
		}
	}
}

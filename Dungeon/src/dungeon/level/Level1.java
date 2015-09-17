package dungeon.level;

public class Level1 extends Level{

	
	public Level1(){
		
		
		entrance= new NormalRoom("entrance");
		intersection= new NormalRoom("intersection");
		intersection.setDescription("There might be something weird on the left...");
		trap=new NormalRoom("trap");
		exit = new NormalRoom("exit");

		
		entrance.setNeighbour("north", intersection);
		intersection.setNeighbour("north", exit);
		intersection.setNeighbour("west", trap);
	
	}

}

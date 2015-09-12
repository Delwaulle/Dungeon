package level;

public class Level1 extends Level{

	
	public Level1(){
		entrance= new NormalRoom("entrance");
		intersection= new NormalRoom("intersection");
		trap=new NormalRoom("trap");
		exit = new NormalRoom("exit");

		
		entrance.setNeighbour("north", intersection);
		intersection.setNeighbour("north", exit);
		intersection.setNeighbour("west", trap);
	
	}

}

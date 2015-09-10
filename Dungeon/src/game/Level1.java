package game;

public class Level1 extends Level{

	
	public Level1(){
		entrance= new Room("entrance");
		intersection= new Room("intersaction");
		trap=new Room("trap");
		exit = new Room("exit");
		
		entrance.setNeighbour("north", intersection);
		intersection.setNeighbour("north", exit);
		intersection.setNeighbour("west", trap);
	
	}

}

package level;

public class Level2 extends Level{
	
	protected NormalRoom passage;
	protected ChestRoom chestRoom ;
	protected MonsterRoom monsterRoom;
	
	public Level2() {
		entrance = new NormalRoom("entrance");
		intersection = new NormalRoom("intersection");
		intersection.setDescription("2 ways, west or east. I can hear something strange on the east...");
		
		chestRoom = new ChestRoom("chestroom");
		chestRoom.setDescription("There is an empty chest on the ground.");
		
		monsterRoom = new MonsterRoom("monsterRoom");
		passage = new NormalRoom("passage");
		passage.setDescription("It turns to the north.");
		
		exit = new NormalRoom("exit");
		
		
		entrance.setNeighbour("north", intersection);
		
		intersection.setNeighbour("west", chestRoom);
		intersection.setNeighbour("east", monsterRoom);
		
		chestRoom.setNeighbour("east", intersection);
		
		monsterRoom.setNeighbour("west", intersection);
		monsterRoom.setNeighbour("east", passage);
		
		passage.setNeighbour("west", monsterRoom);
		passage.setNeighbour("north", exit);
		
	}

}

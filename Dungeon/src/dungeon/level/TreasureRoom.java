package dungeon.level;

import dungeon.item.Chest;

/**
 * @author fguilbert
 * This class is for the specific rooms with a chest inside
 */
public class TreasureRoom extends Room{

	private Chest chest=new Chest();
	
	/**
	 * create a treasure room
	 * @param name
	 * @param level
	 */
	public TreasureRoom(String name,Level level) {
		super(name,level);
	}
	
	/**
	 * create a room with a chest inside in a specific level
	 * @param name
	 * @param chest
	 * @param level
	 */
	public TreasureRoom(String name,Chest chest,Level level){
		super(name,level);
		this.setChest(chest);
	}
	
	@Override
	public String getDescription() {
		return "There is a chest in the middle of the room !";
	}


	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void displayInformation() {
		System.out.println("You are in a treasure room !");
	}


	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @return chest
	 */
	public Chest getChest() {
		return chest;
	}

	/**
	 * set a chest
	 * @param chest
	 */
	public void setChest(Chest chest) {
		this.chest = chest;
	}



}

package dungeon.level;

import dungeon.game.Chest;

public class TreasureRoom extends Room{

	private Chest chest=new Chest();
	
	public TreasureRoom(String name) {
		super(name);
	}
	
	public TreasureRoom(String name,Chest chest){
		super(name);
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

	public Chest getChest() {
		return chest;
	}

	public void setChest(Chest chest) {
		this.chest = chest;
	}



}

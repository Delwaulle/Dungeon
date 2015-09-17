package dungeon.level;

import dungeon.game.Item;

public class TreasureRoom extends Room{

	private Item item;
	
	public TreasureRoom(String name) {
		super(name);
	}
	
	public TreasureRoom(String name,Item item){
		super(name);
		this.setItem(item);
	}
	

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
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

	public Item getItem() {
		return item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub
		
	}



}

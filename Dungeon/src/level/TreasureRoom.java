package level;

public class TreasureRoom implements Room{

	protected String name;
	public TreasureRoom(String string) {
		this.name=name;
	}
	
	@Override
	public void setNeighbour(String direction, Room neighbour) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Room goToDirection(String direction) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getName() {
		return this.name;
	}

}

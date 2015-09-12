package level;

public class NormalRoom implements Room{

	protected String name;
	public NormalRoom(String string) {
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

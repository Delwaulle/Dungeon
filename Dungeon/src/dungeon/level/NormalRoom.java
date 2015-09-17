package dungeon.level;

public class NormalRoom extends Room{

	protected String description;
	
	public NormalRoom(String name) {
		super(name);
	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return this.description;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayInformation() {
		System.out.println("It is a normal room");
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
		
	}

}

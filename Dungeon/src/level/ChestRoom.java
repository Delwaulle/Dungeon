package level;

public class ChestRoom extends Room{

	protected String description;
	
	public ChestRoom(String name) {
		super(name);
	}

	@Override
	public void setDescription(String description) {
		this.description = description;
		
	}

	@Override
	public String getDescription() {
		return this.description;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayInformation() {
		System.out.println("There is a chest room");
		
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}

}

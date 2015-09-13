package level;

public class NormalRoom extends Room{

	protected String name;
	public NormalRoom(String name) {
		super(name);
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
		System.out.println("It is a normal room");
	}

}

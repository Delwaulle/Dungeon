package dungeon.level;

/**
 * @author fguilbert
 * this class is for a basic/normal room
 * without monster, chest or trap
 * and this is not the entrance or the exit
 */
public class NormalRoom extends Room{

	protected String description;
	
	public NormalRoom(String name,Level level) {
		super(name,level);
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayInformation() {
		System.out.println("You are in "+this.name);
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

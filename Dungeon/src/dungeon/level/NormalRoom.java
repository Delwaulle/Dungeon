package dungeon.level;

/**
 * this class is for a basic/normal room
 * without monster, chest or trap
 * and this is not the entrance or the exit
 * @author fguilbert
 * 
 */
public class NormalRoom extends Room{

	protected String description;
	
	public NormalRoom(String name,Level level) {
		super(name,level);
	}


	@Override
	public void displayInformation() {
		System.out.println("You are in "+this.name);
	}

	@Override
	public void action() {
		// TODO Auto-generated method stub
		
	}
}

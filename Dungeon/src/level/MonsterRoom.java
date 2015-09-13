package level;
import game.Monster;

public class MonsterRoom extends Room{
	
	private Monster monster;

	public MonsterRoom(String name) {
		super(name);
	}
	
	public MonsterRoom(String name,Monster monster) {
		super(name);
		this.monster=monster;
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
		System.out.println(monster.getName() + " blocks you the passage !");	
	}

}

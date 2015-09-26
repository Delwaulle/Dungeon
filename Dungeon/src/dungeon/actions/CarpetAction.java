package dungeon.actions;

public class CarpetAction implements Action{

	@Override
	public void apply() {
		System.out.println("carpet yeah");
		
	}
	
	public String toString(){
		return "lift the carpet";
	}

}

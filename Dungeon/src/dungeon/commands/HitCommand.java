package dungeon.commands;
import dungeon.game.Character;

/**
 * @author Loic
 * command to hit a character
 */
public class HitCommand implements Command {
	
	private Character aggressor;
	private Character receiver;
	
	/**
	 * @param aggressor
	 * @param receiver
	 */
	public HitCommand(Character aggressor, Character receiver){
		this.aggressor=aggressor;
		this.receiver=receiver;
	}

	@Override
	public void execute() {
		int aggressorDamages =aggressor.attack();
		System.out.println(aggressor.getName()+" imposed "+aggressorDamages+" damages to " + receiver.getName());
		receiver.getHit(aggressorDamages);
		
	}

}

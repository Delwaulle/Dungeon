package dungeon.level;

import dungeon.game.GameBoard;
import dungeon.game.Trap;
import dungeon.utils.RandomGenerator;

/**
 * this class is for a basic/normal room without monster, chest or trap and this
 * is not the entrance or the exit
 * 
 * @author fguilbert
 * 
 */
public class TrapRoom extends Room {

	protected String description;
	protected Trap trap;

	/**
	 * @param name
	 * @param level
	 */
	public TrapRoom(String name, Level level) {
		super(name, level);
		this.trap = new Trap(RandomGenerator.generateRandomTrap());
	}
	
	/**
	 * @param name
	 * @param trap
	 * @param level
	 */
	public TrapRoom(String name, Trap trap, Level level){
		super(name, level);
		this.trap = trap;
	}


	@Override
	public void displayInformation() {
		System.out.println("You are in " + this.name);
	}

	@Override
	public void action() {
		this.trap.activate(GameBoard.player);
	}
	
	/**
	 * @return the trap
	 */
	public Trap getTrap(){
		return this.trap;
	}
	
	/**
	 * @param trap
	 */
	public void setTrap(Trap trap){
		this.trap = trap;
	}

}

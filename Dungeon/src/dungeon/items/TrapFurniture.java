package dungeon.items;

import dungeon.game.GameBoard;
import dungeon.game.Trap;
import dungeon.utils.RandomGenerator;

/**
 * @author Loic
 * When we examine this furniture it activate a trap
 */
public class TrapFurniture extends Furniture{
	
	private Trap trap;

	/**
	 * @param furniture
	 */
	public TrapFurniture(FurnitureType furniture) {
		super(furniture);
		this.trap=new Trap(RandomGenerator.generateRandomTrap());
	}

	@Override
	public void examine() {
		System.out.println("Bad luck ! There is a trap "+this.furniture.getAction());
		this.trap.activate(GameBoard.player);
	}

}

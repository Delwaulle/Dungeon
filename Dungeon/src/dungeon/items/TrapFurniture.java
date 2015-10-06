package dungeon.items;

import dungeon.game.GameBoard;
import dungeon.game.Trap;

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
		//iniatialize trap
	}

	@Override
	public void examine() {
		System.out.println("Bad luck ! There is a trap "+this.furniture.getAction());
		this.trap.activate(GameBoard.player);
	}

}

package dungeon.items;

/**
 * @author Loic
 * Decor of the rooms, can be a trap furniture or a chest furniture
 */
public abstract class Furniture {

	protected FurnitureType furniture;
	
	
	/**
	 * @param furniture
	 */
	public Furniture(FurnitureType furniture){
		this.furniture=furniture;
	}


	/**
	 * @return furniture
	 */
	public FurnitureType getFurniture() {
		return furniture;
	}
	
	/**
	 * launch the action associated to the furniture when the player try to examine it
	 */
	public abstract void examine();
}

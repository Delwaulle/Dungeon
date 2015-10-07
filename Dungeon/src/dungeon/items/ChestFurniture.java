package dungeon.items;

import dungeon.utils.RandomGenerator;

/**
 * @author Loic
 * When the player examine a chest furniture he discover a chest and can take its content
 */
public class ChestFurniture extends Furniture{

	private Chest chest;
	
	/**
	 * @param furniture
	 */
	public ChestFurniture(FurnitureType furniture) {
		super(furniture);
		this.chest=RandomGenerator.generateRandomChest();
	}

	@Override
	public void examine() {
		System.out.println("You are lucky, you find a chest ! Let's see it ! ");
		System.out.println(this.chest.toString());
		System.out.print("What do you want to do ? \n>");
	}

}

package dungeon.items;

import dungeon.commands.ChestCommand;
import dungeon.commands.CommandFactory;
import dungeon.commands.Mod;
import dungeon.utils.RandomGenerator;

/**
 * @author Loic
 * When the player examine a chest furniture he discover a chest and can take its content
 */
public class ChestFurniture extends Furniture{

	private Chest chest;
	private CommandFactory commandFactory;
	
	/**
	 * @param furniture
	 */
	public ChestFurniture(FurnitureType furniture) {
		super(furniture);
		this.chest=RandomGenerator.generateRandomChest();
	}

	@Override
	public void examine() {	
		this.commandFactory=new CommandFactory(Mod.TREASURE_MOD);
		this.commandFactory.setCommand(new ChestCommand(this.chest));
		this.commandFactory.invoke();
	}

}

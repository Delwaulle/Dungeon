package dungeon.level;

import dungeon.commands.ChestCommand;
import dungeon.commands.CommandFactory;
import dungeon.commands.Mod;
import dungeon.items.Chest;
import dungeon.utils.RandomGenerator;

/**
 * This class is for the specific rooms with a chest inside
 * @author fguilbert
 * 
 */
public class TreasureRoom extends Room{

	private Chest chest;
	private CommandFactory commandFactory;
	
	/**
	 * create a treasure room
	 * @param name
	 * @param level
	 */
	public TreasureRoom(String name,Level level) {
		super(name,level);
		this.chest=RandomGenerator.generateRandomChest();
	}
	
	/**
	 * create a room with a chest inside in a specific level
	 * @param name
	 * @param chest
	 * @param level
	 */
	public TreasureRoom(String name,Chest chest,Level level){
		super(name,level);
		this.setChest(chest);
	}

	@Override
	public void displayInformation() {
		System.out.println("You are in a treasure room !");
	}


	@Override
	public void action() {
		this.commandFactory=new CommandFactory(Mod.TREASURE_MOD);
		this.commandFactory.setCommand(new ChestCommand(this.chest));
		this.commandFactory.invoke();	
		this.displayDirections();
	}


	/**
	 * @return chest
	 */
	public Chest getChest() {
		return chest;
	}

	/**
	 * set a chest
	 * @param chest
	 */
	public void setChest(Chest chest) {
		this.chest = chest;
	}

}

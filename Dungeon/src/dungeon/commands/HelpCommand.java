package dungeon.commands;

/**
 * @author Loïc
 * Just display all the possible commands
 */
public class HelpCommand implements Command{


	@Override
	public void execute() {
		System.out.println("go : go to a direction. You must specify the direction. Ex: \"go north\"");
		System.out.println("describe :  describe you the room.");
		System.out.println("inventory :  shows your inventory.");
		System.out.println("use : use an item in your inventory. You must specify the name of the item. Ex: \"use HEALTH_POTION\"");
		System.out.println("stats : shows your stats.");	
		System.out.println("drop : choose an item to remove of your inventory. Ex: \"drop HEALTH_POTION\"");
		System.out.println("equip : equip a weapon froù your inventory. Ex: \"equip WOODEN_SWORD\"");
	}

}

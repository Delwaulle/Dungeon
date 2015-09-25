package dungeon.commands;

public class HelpCommand implements Command{

	public HelpCommand() {}

	@Override
	public void apply() {
		System.out.println("go : go to a direction. You must specify the direction. Ex: \"go north\"");
		System.out.println("describe :  describe you the room.");
		System.out.println("inventory :  shows your inventory.");
		System.out.println("use : use an item in your inventory. You must specify the name of the item. Ex: \"use Key\"");
		System.out.println("stats : shows your stats");	
	}

}

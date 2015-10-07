package dungeon.commands;

import dungeon.game.Character;
import dungeon.items.Inventory;

/**
 * @author Loic
 * Show the inventory of the character passed in param
 */
public class ShowInventoryCommand implements Command{

	private Character character;
	private final String COMMAND_DESCRIPTION="inventory : Shows the invotory of the character";
	
	/**
	 * @param character
	 */
	public ShowInventoryCommand(Character character) {
		this.character=character;
	}

	@Override
	public void execute() {
		Inventory inventory = character.getInventory();
		System.out.println("Your inventory :");
		System.out.println(inventory.toString());
		System.out.println("================");
	}

	@Override
	public String getDescription() {
		return this.COMMAND_DESCRIPTION;
	}

}

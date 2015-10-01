package dungeon.commands;

import dungeon.game.Character;
import dungeon.items.Inventory;

/**
 * @author Loic
 * Show the inventory of the character passed in param
 */
public class ShowInventoryCommand implements Command{

	private Character character;
	
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

}

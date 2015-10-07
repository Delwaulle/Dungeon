package dungeon.commands;

import dungeon.items.Inventory;
import dungeon.game.Character;

/**
 * @author Loic
 * Show the inventory of the player
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

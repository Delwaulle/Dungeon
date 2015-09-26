package dungeon.commands;

import dungeon.game.GameBoard;
import dungeon.items.Inventory;

public class ShowInventoryCommand implements Command{

	public ShowInventoryCommand() {}

	@Override
	public void apply() {
		Inventory inventory = GameBoard.player.getInventory();
		System.out.println("Your inventory :");
		System.out.println(inventory.toString());
		System.out.println("================");
	}

}

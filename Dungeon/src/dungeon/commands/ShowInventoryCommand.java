package dungeon.commands;

import dungeon.game.GameBoard;
import dungeon.item.Inventory;

public class ShowInventoryCommand implements Command{

	public ShowInventoryCommand() {}

	@Override
	public void apply() {
		Inventory inventory = GameBoard.player.getInventory();
		System.out.println("Your inventory :");
		System.out.println(inventory);
		System.out.println("================");
	}

}

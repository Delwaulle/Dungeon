package dungeon.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.commands.DropCommand;
import dungeon.exceptions.MaxStacksException;
import dungeon.game.Player;
import dungeon.items.Item;
import dungeon.items.StackItem;

public class DropCommandTest {

	private DropCommand command;
	private Player player;
	
	@Test
	public void dropCommandExecutionWithItemInInventoryTest() throws MaxStacksException{
		player = new Player("toto");
		StackItem item = new StackItem(Item.HEALTH_POTION);
		command = new DropCommand(player, item.getType());
		
		assertEquals(3, player.getInventory().getItemByType(Item.HEALTH_POTION).getQuantity());
		
		command.execute();
		
		assertFalse(player.getInventory().isPresent(Item.HEALTH_POTION));
	}
	
	@Test
	public void dropCommandExecutionWithoutItemInInventoryTest() throws MaxStacksException{
		player = new Player("toto");
		StackItem item = new StackItem(Item.DIAMOND_SWORD);
		command = new DropCommand(player, item.getType());
		
		assertFalse(player.getInventory().isPresent(Item.DIAMOND_SWORD));
		
		command.execute();
		
		assertFalse(player.getInventory().isPresent(Item.DIAMOND_SWORD));
	}
	

}

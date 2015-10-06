package dungeon.tests;

import org.junit.Test;

import dungeon.commands.Command;
import dungeon.commands.ConsumePotionCommand;
import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.game.Player;
import dungeon.items.Item;
import dungeon.items.StackItem;
import static org.junit.Assert.*;

public class ConsumePotionTest {

	private Player player;
	
	@Test
	public void consumeHealthPotionTest(){
		this.player = new Player("player");
		int life=5;
		StackItem potion = player.getInventory().getItemByType(Item.HEALTH_POTION);
		player.setCurrentHealth(life);
		
		//test if player has 5HP
		assertEquals(5, player.getCurrentHealth());
		
		//test if player has 3 potions in his inventory before using 1
		assertEquals(3, player.getInventory().getItemByType(Item.HEALTH_POTION).getQuantity());
		
		Command command;
		command = new ConsumePotionCommand(player, potion.getType());
		command.execute();
		
		//test if player has 2 potions in his inventory after using 1
		assertEquals(2, player.getInventory().getItemByType(Item.HEALTH_POTION).getQuantity());
		
		//test if player healed himself and has 6HP now
		assertEquals(life+Item.HEALTH_POTION.getPower(), player.getCurrentHealth());
		
		//test now if the player consume a potion but has not a increase health
		life=18;
		player.setCurrentHealth(life);
		try {
			potion = new StackItem(Item.PROFUSE_HEAL_POTION);
		} catch (MaxStacksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//need to add the potion to the player's inventory
		try {
			player.getInventory().addItem(potion);
		} catch (FullInventoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		command = new ConsumePotionCommand(player, potion.getType());
		
		assertEquals(life, player.getCurrentHealth());
		
		command.execute();
		
		assertTrue(player.getMaxHealth()>= player.getCurrentHealth());
	}
	
	/**
	 * test if the player life does not increase when he drink a potion while he is full life
	 * also test if the potion is not removed from the inventory
	 */
	@Test
	public void consumeHealPotionWhileFullLife(){
		player = new Player("player");
		StackItem potion = player.getInventory().getItemByType(Item.HEALTH_POTION);
		
		// max health of the player 
		assertEquals(player.getMaxHealth(), player.getCurrentHealth());
		//he has 3 potions in his inventory
		assertEquals(3, potion.getQuantity());
		
		Command command = new ConsumePotionCommand(player, potion.getType());
		
		command.execute();
		
		//assert that player is still at 20hp
		//assert that he didn't consume the potion
		assertNotEquals(21, player.getCurrentHealth());
		assertEquals(player.getMaxHealth(), player.getCurrentHealth());
		assertNotEquals(2, potion.getQuantity());
		assertEquals(3, potion.getQuantity());
	}
	
	//test if the player trys to consume a potion which is not in his inventory
	@Test
	public void consumeAPotionNotInInventory(){
		this.player = new Player("player");
		StackItem potion = null;
		
		try {
			 potion = new StackItem(Item.PROFUSE_HEAL_POTION);
		} catch (MaxStacksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		player.setCurrentHealth(15);
		
		Command command = new ConsumePotionCommand(player, potion.getType());
		command.execute();
		
		assertNotEquals(20, player.getCurrentHealth());
		assertEquals(15, player.getCurrentHealth());
		
		
	}
	

}

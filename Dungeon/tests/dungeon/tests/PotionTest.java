package dungeon.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.commands.*;
import dungeon.game.Battle;
import dungeon.game.Monster;
import dungeon.game.Player;
import dungeon.item.Inventory;
import dungeon.item.Item;
import dungeon.item.Potion;


public class PotionTest {
	
	private Player player;
	Command command;
	
	@Test
	public void consumeHealthPotionTest(){
		this.player = new Player("player");
		Potion potion = (Potion) player.getInventory().getItem("Health's_potion");
		//this.action = new ConsumeHealthPotion(player, potion);
		this.command = new ConsumeHealPotionCommand(player, potion);
		player.setCurrentHealth(5);
		
		//test if player has 3 potions in his inventory
		assertEquals(3, player.getInventory().getItem("Health's_potion").getQuantity());
		//test if player has 5HP
		assertEquals(5, player.getCurrentHealth());
		
		command.apply();
		
		//test if player has 2 potions in his inventory after using 1
		assertEquals(2, player.getInventory().getItem("Health's_potion").getQuantity());
		//test if player healed himself and has 6HP now
		assertEquals(6, player.getCurrentHealth());
		
		player.setCurrentHealth(18);
		potion = (Potion) player.getInventory().getItem("Health's_potion");
		potion.setPower(5);
		command = new ConsumeHealPotionCommand(player, potion);
		
		assertEquals(18, player.getCurrentHealth());
		assertEquals(5, potion.getPower());
		
		command.apply();
		
		assertEquals(20, player.getCurrentHealth());
		
	}
	
}

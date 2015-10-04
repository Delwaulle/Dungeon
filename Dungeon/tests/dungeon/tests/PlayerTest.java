package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.commands.EquipItemCommand;
import dungeon.game.Player;
import dungeon.items.Item;
import dungeon.level.Level;

public class PlayerTest {

	@Test
	public void respawnTest() {
		Player player=new Player("toto");
		Level testLevel=new Level(1);
		player.setCurrentLevel(testLevel);
		player.setMaxHealth(10);
		player.setCurrentHealth(10);
		player.getHit(5);
		player.respawn();
		assertEquals(10,player.getCurrentHealth());
	}
	
	@Test
	public void equipPrimaryWeaponTest(){
		Player player = new Player("Tata");
		EquipItemCommand command = new EquipItemCommand(player,Item.WOODEN_SWORD);
		command.execute();
		assertTrue(player.getCurrentWeapon().equals(Item.WOODEN_SWORD));
		int expectingResult = Item.WOODEN_SWORD.getPower() + player.getDamages();
		assertEquals(expectingResult, player.getDamagesWithWeapon());
	}

}

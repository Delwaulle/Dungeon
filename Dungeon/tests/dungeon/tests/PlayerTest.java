package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.commands.Command;
import dungeon.commands.EquipPrimaryWeaponCommand;
import dungeon.game.Player;
import dungeon.items.Weapon;
import dungeon.level.Level;

public class PlayerTest {

	@Test
	public void respawnTest() {
		Player player=new Player("toto");
		Level testLevel=new Level(1);
		player.setMaxHealth(10);
		player.setCurrentHealth(10);
		player.getHit(5);
		player.respawn(testLevel);
		assertEquals(10,player.getCurrentHealth());
	}
	
	@Test
	public void equipPrimaryWeaponTest(){
		Player player = new Player("Tata");
		EquipPrimaryWeaponCommand command = new EquipPrimaryWeaponCommand(player);
		Weapon weapon = (Weapon) player.getInventory().getItem("Wooden_sword");
		command.setWeapon(weapon);
		command.apply();
		
		Weapon primaryWeapon = player.getPrimaryWeapon();
		boolean sameWeapon = false;
		if(primaryWeapon.getName().equals(weapon.getName()));
			sameWeapon = true;
		assertTrue(sameWeapon);
		assertEquals(10, player.getDamagesWithWeapon());
	}

}

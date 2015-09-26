package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.game.Player;
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

}

package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.game.Player;
import dungeon.game.Trap;
import dungeon.game.TrapEnum;
import dungeon.level.TrapRoom;

public class TrapRoomTest {

	
	@Test
	public void trapNameWithConstructorTest(){
		TrapRoom trapRoom = new TrapRoom("trapRoom", new Trap(TrapEnum.FIRE), null); //still no need of level
		assertEquals("Fire", trapRoom.getTrap().getName());
	}
	
	@Test
	public void trapActivationTest(){
		Trap trap = new Trap(TrapEnum.FIRE); //still still no need of level
		Player player = new Player("player");
		player.setCurrentHealth(15);
		int expecting = player.getCurrentHealth()-TrapEnum.FIRE.getPower();
		trap.activate(player);
		assertEquals(expecting, player.getCurrentHealth());
	}
	
}

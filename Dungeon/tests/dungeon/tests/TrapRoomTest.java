package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.game.Player;
import dungeon.game.Trap;
import dungeon.game.TrapEnum;
import dungeon.level.TrapRoom;

public class TrapRoomTest {

	@Test
	public void trapNameNotInConstrcutorTest(){
		TrapRoom trapRoom = new TrapRoom("TrapRoom", null); // no need of level
		assertEquals("Gaz", trapRoom.getTrap().getName());
	}
	
	@Test
	public void trapNameWithConstructorTest(){
		TrapRoom trapRoom = new TrapRoom("trapRoom", new Trap(TrapEnum.FIRE), null); //still no need of level
		assertEquals("Fire", trapRoom.getTrap().getName());
	}
	
	@Test
	public void trapActivationTest(){
		TrapRoom trap = new TrapRoom("trap", new Trap(TrapEnum.FIRE), null); //still still no need of level
		Player player = new Player("player");
		player.setCurrentHealth(15);
		trap.setPlayer(player);
		trap.action();
		
		assertEquals(5, player.getCurrentHealth());
	}
	
}

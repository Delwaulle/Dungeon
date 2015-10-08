package dungeon.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.level.Room;
import dungeon.level.Level;
import dungeon.level.NormalRoom;


/**
 * @author fguilbert
 *
 */
public class LevelTest {

	Level test =new Level(1, 1);
	
		
	/**
	 * @return the win when the player has finished the level
	 */
	@Test
	public void gameIsWonTest() {
		Room currentRoom= new NormalRoom("exit", test);
		test.setCurrentRoom(currentRoom);
		assertTrue(test.gameIsWon());
	}
	

}

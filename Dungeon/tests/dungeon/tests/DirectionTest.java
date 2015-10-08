package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.level.Direction;

public class DirectionTest {

	@Test
	public void isValidDirectionTest() {
		assertTrue(Direction.isValidDirectionEnum("NORTH"));
		assertFalse(Direction.isValidDirectionEnum("not a direction"));
	}
	
	@Test
	public void getOppositeDirectionTest(){
		assertEquals(Direction.NORTH.getOppositeDirection(),Direction.SOUTH);
		assertEquals(Direction.SOUTH.getOppositeDirection(),Direction.NORTH);
		assertEquals(Direction.WEST.getOppositeDirection(),Direction.EAST);
		assertEquals(Direction.EAST.getOppositeDirection(),Direction.WEST);
	}

}

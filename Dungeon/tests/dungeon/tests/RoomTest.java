package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.game.GameBoard;
import dungeon.game.Player;
import dungeon.items.Item;
import dungeon.items.StackItem;
import dungeon.level.*;

public class RoomTest {

	@Test
	public void goToRoomTest(){
		Room room = new NormalRoom("room", null);
		Room room2 = new NormalRoom("room2", null);
		
		room.setNeighbour(new Door(Direction.NORTH), room2);
		
		assertEquals("room2", room.goToDirection(Direction.NORTH).getName());
	}
	
	@Test
	public void descriptionRoomTest(){
		Room room = new NormalRoom("room", null);		
		room.setDescription("description");
		assertEquals("description", room.getDescription());
	}
	
	@Test
	public void notValidDirectionTest(){
		Room room = new NormalRoom("room", null);
		Room room2 = new NormalRoom("room2", null);
		
		room.setNeighbour(new Door(Direction.SOUTH), room2);
		
		assertNull(room.goToDirection(Direction.EAST));
		assertNull(room.goToDirection(Direction.NORTH));
		assertNull(room.goToDirection(Direction.WEST));
	}
	
	@Test
	public void lockedDoorTest() throws MaxStacksException, FullInventoryException{
		Player player = new Player("toto");
		Room room = new NormalRoom("room", null);
		Room room2 = new NormalRoom("room2", null);
		room.setNeighbour(new Door(Direction.SOUTH, false, true), room2);
		room.setPlayer(player);
		
		assertNull(room.goToDirection(Direction.SOUTH));
		
		StackItem key = new StackItem(Item.SAMPLE_KEY);
		player.getInventory().addItem(key);
		
		assertEquals("room2", room.goToDirection(Direction.SOUTH).getName());
	}
	
	@Test
	public void hiddenDoorTest(){
		Player player = new Player("toto");
		Room room = new NormalRoom("room", null);
		Room room2 = new NormalRoom("room2", null);
		room.setNeighbour(new Door(Direction.EAST, true, false), room2);
		room.setPlayer(player);
		
		assertEquals("room2", room.goToDirection(Direction.EAST).getName());
	}

}

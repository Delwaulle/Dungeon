package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.items.Inventory;
import dungeon.items.Item;
import dungeon.items.StackItem;

public class InventoryTest {

	@Test
	public void addItemTest() {
		Inventory inventory=new Inventory();
		StackItem testItem=null;
		try {
			testItem = new StackItem(Item.HEALTH_POTION,1);
			inventory.addItem(testItem);
		} catch (MaxStacksException |FullInventoryException e) {
			e.printStackTrace();
		}
		StackItem itemInInventory = inventory.searchItem(testItem.getType());
		assertEquals(testItem,itemInInventory);
	}
	
	@Test
	public void searchExistingItemTest() {
		Inventory inventory=new Inventory();
		try {
			StackItem testItem = new StackItem(Item.HEALTH_POTION,1);
			inventory.addItem(testItem);
		} catch (FullInventoryException | MaxStacksException e) {
			e.printStackTrace();
		}
		boolean result = inventory.isPresent(Item.HEALTH_POTION);
		assertTrue(result);
	}

	
	@Test
	public void dropItemTest() {
		Inventory inventory=new Inventory();
		StackItem testItem=null;
		try {
			testItem= new StackItem(Item.HEALTH_POTION,1);
			inventory.addItem(testItem);
		} catch (FullInventoryException | MaxStacksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventory.dropItem(testItem.getType());
		boolean result = inventory.isPresent(Item.HEALTH_POTION);
		assertFalse(result);
	}
	
	@Test
	public void useItemTest() {
		Inventory inventory=new Inventory();
		StackItem testItem=null;
		try {
			testItem= new StackItem(Item.HEALTH_POTION,3);
			inventory.addItem(testItem);
		} catch (FullInventoryException | MaxStacksException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		inventory.useItem(Item.HEALTH_POTION,1);
		StackItem expectingItem = inventory.getItemByType(Item.HEALTH_POTION);
		int quantity=expectingItem.getQuantity();
		int expectingQuantity=2;
		assertEquals(quantity,expectingQuantity);
	}

}

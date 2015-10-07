package dungeon.tests;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ArrayList;

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
		inventory.useItem(Item.HEALTH_POTION);
		StackItem expectingItem = inventory.getItemByType(Item.HEALTH_POTION);
		int quantity=expectingItem.getQuantity();
		int expectingQuantity=2;
		assertEquals(quantity,expectingQuantity);
	}
	
	@Test(expected = FullInventoryException.class)
	public void addItemToFullInventoryTest() throws FullInventoryException, MaxStacksException{
		Inventory inventory=new Inventory();
		int quantity = 6;
		inventory.setMaxWeight(Item.HEALTH_POTION.getWeight()*quantity-1);
		inventory.addItem(new StackItem(Item.HEALTH_POTION,quantity));
	}
	
	@Test
	public void isFullInventoryTest() throws FullInventoryException, MaxStacksException{
		Inventory inventory=new Inventory();
		int weight=5;
		inventory.setMaxWeight(weight);
		inventory.addItem(new StackItem(Item.HEALTH_POTION,weight-1));
		assertFalse(inventory.isFull());
		inventory.addItem(new StackItem(Item.STRENGH_POTION,1));
		assertTrue(inventory.isFull());
	}
	
	@Test
	public void addListToInventoryTest() throws FullInventoryException, MaxStacksException{
		Inventory inventory = new Inventory(10000);
		List<StackItem> listToAdd = new ArrayList<StackItem>();
		listToAdd.add(new StackItem(Item.HEALTH_POTION, 3));
		listToAdd.add(new StackItem(Item.STRENGH_POTION, 2));
		inventory.addListToInventory(listToAdd);
		inventory.addListToInventory(listToAdd);
	}

}

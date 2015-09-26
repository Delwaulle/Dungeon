package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.items.Inventory;
import dungeon.items.Item;
import dungeon.items.Potion;

public class InventoryTest {

	@Test
	public void addItemTest() {
		Inventory inventory=new Inventory();
		Item testItem = new Potion("Test_potion",1,1);
		inventory.addItem(testItem);
		Item itemInInventory = inventory.getItems().get(0);
		assertEquals(testItem,itemInInventory);
	}
	
	@Test
	public void searchExistingItemTest() {
		String itemName="Test_potion";
		Inventory inventory=new Inventory();
		Item testItem = new Potion(itemName,1,1);
		inventory.addItem(testItem);
		int result = inventory.searchItem(itemName);
		int expectingResult=0;
		assertEquals(expectingResult,result);
	}
	
	@Test
	public void searchNonExistingItemTest() {
		String itemName="Test_potion";
		String nonExistingItemName="Bad_Item_Name";
		Inventory inventory=new Inventory();
		Item testItem = new Potion(itemName,1,1);
		inventory.addItem(testItem);
		int result = inventory.searchItem(nonExistingItemName);
		int expectingResult=-1;
		assertEquals(expectingResult,result);
	}
	
	@Test
	public void dropItemTest() {
		Inventory inventory=new Inventory();
		String itemName="Test_potion";
		Item testItem = new Potion(itemName,1,1);
		inventory.addItem(testItem);
		inventory.dropItem(testItem);
		int result = inventory.searchItem(itemName);
		int expectingResult=-1;
		assertEquals(expectingResult,result);
	}
	
	@Test
	public void useItemTest() {
		Inventory inventory=new Inventory();
		String itemName="Test_potion";
		Item testItem = new Potion(itemName,1,3);
		inventory.addItem(testItem);
		inventory.useItem(itemName,1);
		Item expectingItem = inventory.getItem(itemName);
		int quantity=expectingItem.getQuantity();
		int expectingQuantity=2;
		assertEquals(quantity,expectingQuantity);
	}

}

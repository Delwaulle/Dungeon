package dungeon.tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import dungeon.exceptions.MaxStacksException;
import dungeon.items.Chest;
import dungeon.items.Item;
import dungeon.items.StackItem;

public class ChestTest {

	@Test
	public void initializeChestTest() {
		Chest chest = new Chest();
		assertEquals(chest.getItems().get(0).getType(),Item.HEALTH_POTION);
		assertEquals(chest.getItems().get(0).getQuantity(),2);
	}
	
	@Test
	public void initializeChestWithListTest() {
		List<StackItem> liste = new ArrayList<StackItem>();
		StackItem testItem=null;
		try {
			testItem = new StackItem(Item.WOODEN_SWORD,1);
		} catch (MaxStacksException e) {
			e.printStackTrace();
		}
		liste.add(testItem);
		Chest chest = new Chest(liste);
		assertEquals(chest.getItems().get(0).getType(),testItem.getType());
		assertEquals(chest.getItems().get(0).getQuantity(),testItem.getQuantity());
	}

}

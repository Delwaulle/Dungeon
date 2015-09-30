package dungeon.tests;


import org.junit.Test;
import dungeon.exceptions.MaxStacksException;
import dungeon.items.Item;
import dungeon.items.StackItem;

public class ItemTest {

	@Test(expected = MaxStacksException.class)
	public void createFullStackItemTest() throws MaxStacksException{
		int overMaxStack=Item.HEALTH_POTION.getMaxStack()+1;
		new StackItem(Item.HEALTH_POTION,overMaxStack);	
	}

}

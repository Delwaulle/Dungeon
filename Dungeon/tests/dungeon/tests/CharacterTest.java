package dungeon.tests;

import static org.junit.Assert.*;
import dungeon.game.Character;
import dungeon.game.Player;
import dungeon.items.Item;

import org.junit.Test;

public class CharacterTest {

	@Test
	public void getHitTest(){
		Character character = new Player("toto");
		character.setCurrentHealth(10);
		character.getHit(5);
		assertEquals(5,character.getCurrentHealth());	
	}
	
	@Test
	public void criticalHitTest(){
		Character character = new Player("toto");
		character.setPourcentCriticalHit(100); //set to 100% the critical hit pourcentage's
		character.setPowerOfCriticalHit(2);
		character.setDamages(10);
		assertEquals(character.attack(),character.getDamages()+character.getPowerOfCriticalHit());
	}
	
	@Test
	public void normalHitTest(){
		Character character = new Player("toto");
		character.setPourcentCriticalHit(0); //set to 0% the critical hit pourcentage's
		character.setDamages(10);
		assertEquals(character.attack(),10);
	}
	
	@Test
	public void calculatePourcentCriticalHitByLevelTest(){
		
		Character character = new Player("toto");
		int level=1;
		int res = character.calculatePourcentCriticalHitByLevel(level);
		assertEquals(4,res);
	}
	
	
	@Test
	public void getDropTest(){
		Character character = new Player("toto");
		Character characterDrop = new Player("tata");
		int expectingQuantity= character.getInventory().getItemByType(Item.HEALTH_POTION).getQuantity()*2;
		character.getDrop(characterDrop);	
		assertEquals(character.getInventory().getItemByType(Item.HEALTH_POTION).getQuantity(),expectingQuantity);
		assertEquals(character.getInventory().getItemByType(Item.WOODEN_SWORD).getQuantity(),Item.WOODEN_SWORD.getMaxStack());
	}

}

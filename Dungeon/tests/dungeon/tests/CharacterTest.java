package dungeon.tests;

import static org.junit.Assert.*;
import dungeon.game.Character;
import org.junit.Test;

public class CharacterTest {

	@Test
	public void getHitTest(){
		Character character = new Character("toto");
		character.setCurrentHealth(10);
		character.getHit(5);
		assertEquals(5,character.getCurrentHealth());	
	}
	
	@Test
	public void isDieTest(){
		Character character = new Character("toto");
		character.setCurrentHealth(10);
		character.getHit(10);
		assertTrue(character.isDead());
	}
	
	@Test
	public void criticalHitTest(){
		Character character = new Character("toto");
		character.setPourcentCriticalHit(100); //set to 100% the critical hit pourcentage's
		character.setPowerOfCriticalHit(2);
		character.setDamages(10);
		assertEquals(character.attack(),20);
	}
	
	@Test
	public void normalHitTest(){
		Character character = new Character("toto");
		character.setPourcentCriticalHit(0); //set to 0% the critical hit pourcentage's
		character.setDamages(10);
		assertEquals(character.attack(),10);
	}

}

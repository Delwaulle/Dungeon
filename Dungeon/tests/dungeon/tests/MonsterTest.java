package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.game.GameBoard;
import dungeon.game.Monster;
import dungeon.game.MonsterEnum;
import dungeon.game.Character;
import dungeon.game.Player;

public class MonsterTest {

	@Test
	public void dieTest() {
		GameBoard.player=new Player("toto");
		Character monster=new Monster(MonsterEnum.DEVIL_CAT, 1);		
		monster.getHit(13);
		assertTrue(monster.isDead());
	}

}

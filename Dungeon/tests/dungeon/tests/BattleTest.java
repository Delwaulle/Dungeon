package dungeon.tests;
import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.game.Battle;
import dungeon.game.Monster;
import dungeon.game.Player;


public class BattleTest {

	@Test
	public void testFightPlayerWin() {
		Monster monster = new Monster("ghost");
		monster.setDamages(5);
		monster.setHealth(10);
		Player player= new Player("Toto");
		player.setLives(20);
		player.setDamages(10);
		Battle battle = new Battle(player,monster);
		assertEquals(battle.fight(),0);
	}
	
	@Test
	public void testFightMonsterWin() {
		Monster monster = new Monster("ghost");
		monster.setDamages(20);
		monster.setHealth(30);
		Player player= new Player("Toto");
		player.setLives(20);
		player.setDamages(5);
		Battle battle = new Battle(player,monster);
		assertEquals(battle.fight(),0);
	}

}

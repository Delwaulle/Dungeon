package dungeon.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import dungeon.commands.HitCommand;
import dungeon.game.Monster;
import dungeon.game.MonsterEnum;
import dungeon.game.Player;

public class HitCommandTest {

	private HitCommand command;
	private Player player;
	private Monster monster;
	
	@Test
	public void hitCommandExecutionTest(){
		player = new Player("toto");
		monster = new Monster(MonsterEnum.DEVIL_CAT, 1);
		command = new HitCommand(player, monster);
		
		assertEquals(12, monster.getCurrentHealth());//with the level, monster health is increase
		assertEquals(7, player.getDamagesWithWeapon());
		
		command.execute();
		
		assertEquals(5, monster.getCurrentHealth());
		
		
	}

}

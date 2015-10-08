package dungeon.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dungeon.commands.CommandFactory;
import dungeon.commands.Mod;
import dungeon.game.Monster;
import dungeon.game.MonsterEnum;
import dungeon.game.Player;
import dungeon.level.Level;

public class CommandFactoryTest {
	private CommandFactory commandFac;
	
	@Test
	public void validCommandInFactory(){
		commandFac = new CommandFactory(Mod.BASIC_MOD);
		
		assertTrue(commandFac.isValidCommandWithMod("go"));
		assertTrue(commandFac.isValidCommandWithMod("stats"));
		assertTrue(commandFac.isValidCommandWithMod("help"));
		assertTrue(commandFac.isValidCommandWithMod("equip"));
		assertTrue(commandFac.isValidCommandWithMod("describe"));
		assertTrue(commandFac.isValidCommandWithMod("inventory"));
		assertFalse(commandFac.isValidCommandWithMod("hit"));
		
	}
	
	@Test
	public void interpretCommandTest(){
		commandFac = new CommandFactory(Mod.BASIC_MOD);
		String[]cmd = new String[]{"go","north"};
		assertTrue(commandFac.interpretCommand(cmd, new Player("toto"), new Level(1,1), null, new Monster(MonsterEnum.DEVIL_CAT,1), null));
		String[]cmd2 = new String[]{"help"};
		assertFalse(commandFac.interpretCommand(cmd2, null, null, null, null, null));
	}
}

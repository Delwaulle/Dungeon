package dungeon.tests;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import dungeon.commands.CommandFactory;
import dungeon.commands.Mod;

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
}

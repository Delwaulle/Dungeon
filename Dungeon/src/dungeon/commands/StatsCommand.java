package dungeon.commands;

import dungeon.game.Character;

/**
 * @author Loic
 * This command show the stats of the Character passed in param
 */
public class StatsCommand implements Command{
	
	private Character character;
	private final String COMMAND_DESCRIPTION="stats : shows stats of the character.";
	
	/**
	 * @param player
	 */
	public StatsCommand(Character character) {
		this.character = character;
	}
	
	@Override
	public void execute() {
		System.out.println(character.getName() + " stats");
		System.out.println("====================");
		System.out.println("Heath = " + character.getCurrentHealth()+ "/" + character.getMaxHealth());
		System.out.println("Damages = " + character.getDamages());
		if(character.getCurrentWeapon() != null){
			System.out.println("Primary Weapon = " + character.getCurrentWeapon().name());
			System.out.println("               -Weapon Damages = " + character.getCurrentWeapon().getPower());
			System.out.println("Total Damages = " + character.getDamagesWithWeapon());
		}
		System.out.println("Critical hit chance = " + character.getPourcentCriticalHit()+"%");
		System.out.println("Critical hit power = " + character.getPowerOfCriticalHit());
		System.out.println("====================");
	}

	@Override
	public String getDescription() {
		return this.COMMAND_DESCRIPTION;
	}
	
	


}

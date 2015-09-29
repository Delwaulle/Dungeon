package dungeon.commands;

import dungeon.game.Player;

public class StatsCommand implements Command{
	
	private Player player;

	public StatsCommand(Player player) {
		this.player = player;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	@Override
	public void apply() {
		System.out.println(player.getName() + " stats");
		System.out.println("====================");
		System.out.println("Heath = " + player.getCurrentHealth()+ "/" + player.getMaxHealth());
		System.out.println("Damages = " + player.getDamages());
		if(player.getCurrentWeapon() != null){
			System.out.println("Primary Weapon = " + player.getCurrentWeapon().name());
			System.out.println("               -Weapon Damages = " + player.getCurrentWeapon().getPower());
			System.out.println("Total Damages = " + player.getDamagesWithWeapon());
		}
		System.out.println("Critical hit chance = " + player.getPourcentCriticalHit());
		System.out.println("Critical hit power = " + player.getPowerOfCriticalHit());
		System.out.println("====================");
	}
	
	


}

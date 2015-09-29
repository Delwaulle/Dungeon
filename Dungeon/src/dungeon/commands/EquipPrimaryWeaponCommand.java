package dungeon.commands;

import dungeon.game.Player;
import dungeon.items.Item;

public class EquipPrimaryWeaponCommand implements Command{

	private Player player;
	private Item weapon;
	
	public EquipPrimaryWeaponCommand(Player player) {
		this.player = player;
	}

	@Override
	public void apply() {
		player.setCurrentWeapon(weapon);
		System.out.println("Your primary weapon is now : " + weapon.name());
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}

	

}

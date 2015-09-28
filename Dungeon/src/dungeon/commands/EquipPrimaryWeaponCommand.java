package dungeon.commands;

import dungeon.game.Player;
import dungeon.items.Weapon;

public class EquipPrimaryWeaponCommand implements Command{

	private Player player;
	private Weapon weapon;
	
	public EquipPrimaryWeaponCommand(Player player) {
		this.player = player;
	}

	@Override
	public void apply() {
		player.setPrimaryWeapon(weapon);
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
	}

}

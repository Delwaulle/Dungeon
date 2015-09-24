package dungeon.action;

import dungeon.item.*;
import dungeon.game.*;

/**
 * @author cbreuzon create the command in order to consume a health potion
 *
 */
public class ConsumeHealthPotion implements Action {

	private Potion potion;
	private Player player;

	public ConsumeHealthPotion(Player player, Potion potion) {
		this.player = player;
		this.potion = potion;
	}

	/**
	 * execute the command
	 */
	@Override
	public void execute() {
		if (player.getInventory().searchItem(potion.getName()) != -1) {

			if (player.getCurrentHealth() < player.getMaxHealth()) {
				if (player.getCurrentHealth() + potion.getPower() > player
						.getMaxHealth())
					player.setCurrentHealth(player.getMaxHealth());
				else
					player.setCurrentHealth(player.getCurrentHealth()
							+ potion.getPower());
			}

			player.getInventory().useItem(potion.getName(), 1);
		}
	}

}

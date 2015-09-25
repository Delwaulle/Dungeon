package dungeon.commands;

import dungeon.game.Player;
import dungeon.item.Potion;

public class ConsumeHealPotionCommand implements Command{

	private Player player;
	private Potion potion;
	
	public ConsumeHealPotionCommand(Player player, Potion potion) {
		this.player = player;
		this.potion = potion;
	}

	@Override
	public void apply() {
		if (player.getInventory().searchItem(potion.getName()) != -1) {
		
			if (player.getCurrentHealth() < player.getMaxHealth()){
				if ((player.getCurrentHealth() + potion.getPower()) > player
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

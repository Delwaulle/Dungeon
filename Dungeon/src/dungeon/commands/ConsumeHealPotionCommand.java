package dungeon.commands;

import dungeon.game.GameBoard;
import dungeon.game.Player;
import dungeon.items.Item;

public class ConsumeHealPotionCommand implements Command{

	private Player player;
	private Item potion;
	
	public void setPotion(Item potion) {
		this.potion = potion;
	}

	public ConsumeHealPotionCommand(Player player) {
		this.player = player;
	}
	
	@Override
	public void apply() {
		if (player.getInventory().isPresent(potion)) {
		
			if (player.getCurrentHealth() < player.getMaxHealth()){
				if ((player.getCurrentHealth() + potion.getPower()) > player
						.getMaxHealth())
					player.setCurrentHealth(player.getMaxHealth());
				else
					player.setCurrentHealth(player.getCurrentHealth()
							+ potion.getPower());
				
				player.getInventory().useItem(potion, 1);
				System.out.println("You have now " + GameBoard.player.getCurrentHealth());
			}
		}
		else{
			System.out.println("There is no kind of \"" + this.potion.name() + "\" in your inventory.");
		}
	}
	

}

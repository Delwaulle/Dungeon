package dungeon.commands;

import dungeon.game.GameBoard;
import dungeon.game.Player;
import dungeon.items.Potion;

public class ConsumeHealPotionCommand implements Command{

	private Player player;
	private Potion potion;
	
	public ConsumeHealPotionCommand(Player player) {
		this.player = player;
	}
	
	public Potion getPotion() {
		return potion;
	}

	public void setPotion(Potion potion) {
		this.potion = potion;
	}

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
				
				player.getInventory().useItem(potion.getName(), 1);
				System.out.println("You have now " + GameBoard.player.getCurrentHealth());
			}
		}
		else{
			System.out.println("There is no kind of \"" + this.potion.getName() + "\" in your inventory.");
		}
	}
	

}

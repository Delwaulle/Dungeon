package dungeon.item;

import dungeon.action.Action;
import dungeon.game.Player;

/**
 * @author fguilbert
 * the player can use some potions for healing or having more strength
 */
public class Potion extends Item implements Action{
	

	private int power;
	
	public Potion(String name,int power) {
		super(name);
		this.power=power;
	}
	
	public Potion(String name,int power,int quantity) {
		super(name,quantity);
		this.power=power;
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public String toString(){
		return this.name+" (x"+this.quantity+") - Power : "+
				this.power;
	}
	
	/**
	 * execute the command
	 */
	@Override
	public void consume(Player player) {
		if (player.getInventory().searchItem(this.getName()) != -1) {
		
			if (player.getCurrentHealth() < player.getMaxHealth()){
				if ((player.getCurrentHealth() + this.getPower()) > player
						.getMaxHealth())
					player.setCurrentHealth(player.getMaxHealth());
				else
					player.setCurrentHealth(player.getCurrentHealth()
							+ this.getPower());
				
			}

			player.getInventory().useItem(this.getName(), 1);
		}
	}

}

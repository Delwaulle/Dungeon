package dungeon.commands;

import dungeon.game.GameBoard;
import dungeon.game.Character;
import dungeon.items.Item;

/**
 * @author Loic
 *	This command serves to use a health potion and update the life of the character in consequences
 */
public class ConsumeHealPotionCommand implements Command{

	private Character character;
	private String potion;
	private Item item;

	/**
	 * @param character
	 * @param potionName
	 */
	public ConsumeHealPotionCommand(Character character,String potion) {
		this.character = character;
		this.potion=potion;
	}
	
	/**
	 * @param character
	 * @param potionName
	 */
	public ConsumeHealPotionCommand(Character character,Item item) {
		this.character = character;
		this.item=item;
		this.potion=item.name();
	}
	
	@Override
	public void execute() {
		
		if ((Item.isValidItemEnum(potion.toUpperCase()) && this.character.getInventory().isPresent(Item.valueOf(potion.toUpperCase())))) {	
			item=this.character.getInventory().getItemByType(Item.valueOf(potion.toUpperCase())).getType();
			if (character.getCurrentHealth() < character.getMaxHealth()){
				if ((character.getCurrentHealth() + item.getPower()) > character
						.getMaxHealth())
					character.setCurrentHealth(character.getMaxHealth());
				else
					character.setCurrentHealth(character.getCurrentHealth()
							+ item.getPower());
				character.getInventory().useItem(item, 1);
				System.out.println("You have now " + GameBoard.player.getCurrentHealth());
			}
			else
				System.out.println("You are full life : "+GameBoard.player.getCurrentHealth()+" HP.");
		}
		else{
			System.out.println("There is no kind of \"" + potion + "\" in your inventory.");
			this.character.getInventory().showAllEdibleItems();
		}
	}
	

}

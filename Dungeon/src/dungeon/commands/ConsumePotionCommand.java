package dungeon.commands;

import dungeon.game.Character;
import dungeon.items.Item;

/**
 * @author Loic
 *	This command serves to use a health potion and update the life of the character in consequences
 */
public class ConsumePotionCommand implements Command{

	private Character character;
	private String potion;
	private Item item;
	private final String COMMAND_DESCRIPTION = "use : use an item in your inventory. You must specify the name of the item. Ex: \"use HEALTH_POTION\"";

	/**
	 * @param character
	 * @param potionName
	 */
	public ConsumePotionCommand(Character character,String potion) {
		this.character = character;
		this.potion=potion;
	}
	
	/**
	 * @param character
	 * @param potionName
	 */
	public ConsumePotionCommand(Character character,Item item) {
		this.character = character;
		this.item=item;
		this.potion=item.name();
	}
	
	@Override
	public void execute() {
		
		if ((Item.isValidItemEnum(potion.toUpperCase()) && this.character.getInventory().isPresent(Item.valueOf(potion.toUpperCase())))) {	
			item=this.character.getInventory().getItemByType(Item.valueOf(potion.toUpperCase())).getType();
			if(item==Item.HEALTH_POTION){
				if (character.getCurrentHealth() < character.getMaxHealth()){
					if ((character.getCurrentHealth() + item.getPower()) > character
							.getMaxHealth()){
						character.setCurrentHealth(character.getMaxHealth());
					}
					else
						character.setCurrentHealth(character.getCurrentHealth()+ item.getPower());
					character.getInventory().useItem(item);
					System.out.println("You have now " + character.getCurrentHealth());

				}
				else
					System.out.println("You are full life : "+character.getCurrentHealth()+" HP.");
			}
			else if (item==Item.STRENGH_POTION){
				character.setDamages(character.getDamages()+Item.STRENGH_POTION.getPower());
				System.out.println("You have now "+character.getDamages()+" power !");

			}
		}
		else{
			System.out.println("There is no kind of \"" + potion + "\" in your inventory.");
			this.character.getInventory().showAllEdibleItems();
		}
	}

	@Override
	public String getDescription() {
		return this.COMMAND_DESCRIPTION;
	}
	

}

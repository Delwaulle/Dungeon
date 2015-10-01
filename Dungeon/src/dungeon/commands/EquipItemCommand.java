package dungeon.commands;

import dungeon.game.Character;
import dungeon.items.Item;

/**
 * @author Loïc
 * This command equip the item passed in param to the current weapon of the character
 */
public class EquipItemCommand implements Command{

	private Character character;
	private Item item;
	private String equipValue;
	
	/**
	 * @param player
	 * @param itemName
	 */
	public EquipItemCommand(Character character,String equipValue) {
		this.character = character;
		this.equipValue=equipValue;
	}

	/**
	 * @param player
	 * @param Item
	 */
	public EquipItemCommand(Character character,Item item) {
		this.character = character;
		this.item=item;
		this.equipValue=item.name();
	}
	
	@Override
	public void execute() {
		if ((Item.isValidItemEnum(equipValue.toUpperCase()) && this.character.getInventory().isPresent(Item.valueOf(equipValue.toUpperCase())))) {	
			item=this.character.getInventory().getItemByType(Item.valueOf(equipValue.toUpperCase())).getType();
		character.setCurrentWeapon(item);
		System.out.println("Your current weapon is now : " + item.name());
		}
		else{
			System.out.println("There is no kind of \"" + equipValue + "\" in your inventory.");
			this.character.getInventory().showAllEquipableItems();
		}
	}


}

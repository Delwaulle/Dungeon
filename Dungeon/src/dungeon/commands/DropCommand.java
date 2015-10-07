package dungeon.commands;

import dungeon.game.Character;
import dungeon.items.Item;

/**
 * @author Loic
 * The command to drop an item (remove it from the character's inventory)
 */
public class DropCommand implements Command{

	private Character character;
	private Item item;
	private String equipValue;
	
	/**
	 * @param player
	 * @param nameItem
	 */
	public DropCommand(Character character,String equipValue) {
		this.character = character;
		this.equipValue=equipValue;
	}
	
	/**
	 * @param player
	 * @param item
	 */
	public DropCommand(Character character,Item item) {
		this.character = character;
		this.item=item;
		this.equipValue=item.name();
	}

	@Override
	public void execute() {
		if ((Item.isValidItemEnum(equipValue.toUpperCase()) && this.character.getInventory().isPresent(Item.valueOf(equipValue.toUpperCase())))) {	
			item=this.character.getInventory().getItemByType(Item.valueOf(equipValue.toUpperCase())).getType();
			character.getInventory().dropItem(item);
			System.out.println("You have dropped : " + item.name());
		}
		else {
			System.out.println("There is no kind of \"" + equipValue + "\" in your inventory.");
			System.out.println(" Your inventory :");
			System.out.println(this.character.getInventory().getItems().toString());
		}
	}

}

package dungeon.commands;

import dungeon.exceptions.FullInventoryException;
import dungeon.game.GameBoard;
import dungeon.items.Chest;
import dungeon.items.Item;
import dungeon.utils.SecureInput;

/**
 * @author Loic
 * all the actions associate to a chest
 */
public class ChestCommand implements Command{

	private Chest chest;
	
	/**
	 * @param chest
	 */
	public ChestCommand(Chest chest){
		this.chest=chest;
	}
	
	
	@Override
	public void execute() {
		System.out.println("You are lucky, you find a chest ! Let's see it ! ");
		System.out.println(this.chest.toString());
		System.out.print("What do you want to do ? (Press help to show the possible commands)\n>");
		String answer = SecureInput.getNoEmptyStringInput();
		String[] cmd = answer.split(" ",2);
		if(cmd[0].equals("take")){
			String arg="";
			if(cmd.length!=2){
				System.out.println("Argument is missing !");
				execute();
			}
			arg=cmd[1];
			if(cmd[1].equals("all")){
				try {
					GameBoard.player.getInventory().addListToInventory(this.chest.getItems());
					new ShowInventoryCommand(GameBoard.player).execute();
				} catch (FullInventoryException e) {
					System.out.println("You are full inventory, you can't add all the items");
					execute();
				}
			}
			else if ((Item.isValidItemEnum(arg.toUpperCase()) && this.chest.isPresent(Item.valueOf(arg.toUpperCase())))) {	
				try {
					GameBoard.player.getInventory().addItem(this.chest.getItemByType(Item.valueOf(arg.toUpperCase())));
					new ShowInventoryCommand(GameBoard.player).execute();
				} catch (FullInventoryException e) {
					System.out.println("You are full inventory, you can't add this item");
					execute();
				}
			}
			else{
				System.out.println("There is no kind of \"" + arg + "\" in your inventory.");
				execute();
			}
			
		}	
		else if(cmd[0].equals("help")){
			new HelpCommand(Mod.TREASURE_MOD).execute();
			execute();
		}
		else if(cmd[0].equals("ignore"))
			System.out.println("You choose to ignore this chest, you can take its content later !");
		else{
			System.out.println("I don't know what you mean. Type \"help\" to show the differents commands.");
			execute();
		}
	}

}

package dungeon.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Loïc
 * Just display all the possible commands
 */
public class HelpCommand implements Command{
	
	private Mod mod;
	private Map<String,String> commandDescription;
	
	public HelpCommand(Mod mod){
		this.mod=mod;
		initializeMap();
	}

	public void initializeMap(){
		this.commandDescription=new HashMap<>();
		this.commandDescription.put("go", "go to a direction. You must specify the direction. Ex: \"go north\"");
		this.commandDescription.put("describe", "describe the room.");
		this.commandDescription.put("inventory", "shows your inventory.");
		this.commandDescription.put("use", "use an item in your inventory. You must specify the name of the item. Ex: \"use HEALTH_POTION\"");
		this.commandDescription.put("stats", "shows stats of the character.");
		this.commandDescription.put("drop", "choose an item to remove of your inventory. Ex: \"drop HEALTH_POTION\"");
		this.commandDescription.put("equip", "equip a weapon from your inventory. Ex: \"equip WOODEN_SWORD\"");
		this.commandDescription.put("examine", "examine a furniture present in the room. Ex :\"examine carpet\"");
		this.commandDescription.put("hit", "hit a character");
		this.commandDescription.put("take", "take an object/all objects to the chest to your inventory");
		this.commandDescription.put("ignore", "ignore the content of the chest and continue your adventure");
	}
	
	@Override
	public void execute() {		
		String []modCmd = this.mod.getListCommands();
		System.out.println("***********************************************************************************************************");
		for(int i=0;i<modCmd.length;i++){
			if(commandDescription.containsKey(modCmd[i]))
				System.out.println("- "+modCmd[i]+" : "+commandDescription.get(modCmd[i]));
		}
		System.out.println("***********************************************************************************************************");

	}

}

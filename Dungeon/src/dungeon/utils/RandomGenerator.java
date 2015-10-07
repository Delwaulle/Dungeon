package dungeon.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dungeon.exceptions.MaxStacksException;
import dungeon.game.MonsterEnum;
import dungeon.game.TrapEnum;
import dungeon.items.Chest;
import dungeon.items.FurnitureType;
import dungeon.items.Inventory;
import dungeon.items.Item;
import dungeon.items.StackItem;
import dungeon.level.Direction;

/**
 * @author Loic
 * Generate randomly all the entity which are needed in the dungeon
 */
public class RandomGenerator {
	
	/**
	 * @return a random direction
	 */
	public static Direction generateRandomDirection(){
		Random r = new Random();
		int valeurMax= Direction.values().length;
		Direction randomDirection= Direction.values()[r.nextInt(valeurMax)];
		return randomDirection;
	}
	
	/**
	 * @return a random item
	 */
	public static Item generateRandomItem(){
		Random r = new Random();
		int valeurMax= Item.values().length;
		Item randomItem= Item.values()[r.nextInt(valeurMax)];
		return randomItem;
	}	
	
	/**
	 * @return a random item list
	 */
	public static List<StackItem> generateRandomItemList(){
		Random r = new Random();
		int nbMaxItems= Constants.MAX_RANDOM_ITEM;
		int nbItems=r.nextInt(nbMaxItems+1);
		List<StackItem> randomItemList= new ArrayList<>();
		int quantity;
		for(int i =0; i<nbItems;i++){
			Item randomItem=generateRandomItem();
			quantity=r.nextInt(randomItem.getMaxStack());
			try {
				randomItemList.add(new StackItem(randomItem,quantity));
			} catch (MaxStacksException e) {
				e.printStackTrace();
			}
		}
		return randomItemList;
	}
	
	/**
	 * @return a random chest
	 */
	public static Chest generateRandomChest(){
		
		Chest randomChest= new Chest(generateRandomItemList());
		return randomChest;
	}	
	
	/**
	 * @return a random inventory
	 */
	public static Inventory generateRandomInventory(){
		Inventory randomInventory=new Inventory(Constants.MAX_WEIGHT_INVENTORY,generateRandomItemList());
		return randomInventory;
	}	
	
	/**
	 * @return a random monster
	 */
	public static MonsterEnum generateRandomMonster(){
		Random r = new Random();
		int valeurMax= MonsterEnum.values().length;
		MonsterEnum randomMonster= MonsterEnum.values()[r.nextInt(valeurMax)];
		return randomMonster;
	}
	
	/**
	 * @return a random trap
	 */
	public static TrapEnum generateRandomTrap(){
		Random r = new Random();
		int valeurMax= TrapEnum.values().length;
		TrapEnum randomTrap= TrapEnum.values()[r.nextInt(valeurMax)];
		return randomTrap;
	}
	
	/**
	 * @return a random furniture
	 */
	public static FurnitureType generateRandomFurniture(){
		Random r = new Random();
		int valeurMax= FurnitureType.values().length;
		FurnitureType randomFurniture= FurnitureType.values()[r.nextInt(valeurMax)];
		return randomFurniture;
	}
	
	
	
}

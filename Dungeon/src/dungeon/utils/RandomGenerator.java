package dungeon.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import dungeon.exceptions.MaxStacksException;
import dungeon.game.MonsterEnum;
import dungeon.game.TrapEnum;
import dungeon.items.Chest;
import dungeon.items.ChestFurniture;
import dungeon.items.Furniture;
import dungeon.items.FurnitureType;
import dungeon.items.Inventory;
import dungeon.items.Item;
import dungeon.items.StackItem;
import dungeon.items.TrapFurniture;
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
	 *  /!\ CRITICAL FUNCTION /!\ hard to test
	 * @return a random item considerate his rarity
	 */
	public static Item generateRandomItem(){
		Random r = new Random();
		List<Item> itemsMultiplyByRarity=new ArrayList<Item>();
		int nbOfItems= Item.values().length;
		Item item;
		for(int i=0;i<nbOfItems;i++){
			item=Item.values()[i];
			int rarity=item.getRarity();
			//More the rarity of the object is important less it will be present in the list
			int rapport=(int)(((double)1/rarity)*Constants.MAX_ITEM_RARITY);
			//rapport will be more important than the object is not rare then we add it more time in the list
			for(int j=0;j<rapport;j++){
				itemsMultiplyByRarity.add(item);
			}	
		}	
		// now me take a random in the list
		int valeurMax=itemsMultiplyByRarity.size();
		int random=r.nextInt(valeurMax);
		Item randomItem= itemsMultiplyByRarity.get(random);
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
			quantity=r.nextInt(randomItem.getMaxStack())/3+1;
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
	
	/**
	 * @param furnitureType
	 * @return randomly a chest furniture or a trap furniture
	 */
	public static Furniture generateRandomFurnitureType(FurnitureType furnitureType){
		Random r = new Random();
		int valeurMax=2;
		int random=r.nextInt(valeurMax);
		if(random==0)
			return new ChestFurniture(furnitureType);
		return new TrapFurniture(furnitureType);
	}
	
	/**
	 * @return a random list of furnitures
	 */
	public static List<Furniture> generateRandomFurnitureList(){
		int nbMaxFurniture=Constants.MAX_RANDOM_FURNITURE;
		List<Furniture> list=new ArrayList<Furniture>();
		for(int i=0;i<nbMaxFurniture;i++){
			list.add(generateRandomFurnitureType(generateRandomFurniture()));
		}
		return list;
	}
	
	
	
}

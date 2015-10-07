package dungeon.items;

import java.util.ArrayList;
import java.util.List;

import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.utils.Constants;

/**
 * Inventory contains a list of items with a max weight
 * @author Loic
 *
 */
public class Inventory {
	protected List<StackItem> items;
	protected int maxWeight;
	
	/**
	 * Empty constructor
	 * Set the constant MAX_WEIGHT_INVENTORY to the max weight of the inventory
	 */
	public Inventory(){
		this(Constants.MAX_WEIGHT_INVENTORY);
	}
	
	/**
	 * Intanstiate the inventory with a max weight
	 * @param maxWeight
	 */
	public Inventory(int maxWeight){
		this(maxWeight,new ArrayList<StackItem>());
	}
	
	
	/**
	 * Instanciate the inventory with a itemList
	 * @param maxWeight
	 * @param itemList
	 */
	public Inventory(int maxWeight,List<StackItem> itemList){
		this.maxWeight=maxWeight;
		this.items=itemList;
	}
	
	/**
	 * Add the item to the player's inventory if it isn't contains it and not too heavy
	 * @param item
	 */
	public void addItem(StackItem item)throws FullInventoryException{
		if (item.getWeight()+this.getCurrentWeight()>maxWeight)
			throw new FullInventoryException();
		if(isPresent(item.getType()))
			try {
				items.get(items.indexOf(item)).updateQuantity(item.getQuantity());
			} catch (MaxStacksException e) {
				e.printStackTrace();
			}
		else
			this.items.add(item);
	}
	
	
	/**
	 * Display all the items to the inventory which are edible
	 */
	public void showAllEdibleItems(){
		System.out.println("Yours edible(s) item(s) :");
		for(StackItem item : this.items){
			if(item.getType().isEdible())
				System.out.println(item.toString());
		}
		System.out.println("===========================================================");
	}
	
	
	/**
	 * Display all the items to the inventory which are equipable
	 */
	public void showAllEquipableItems(){
		System.out.println("Yours equipable(s) item(s) :");
		for(StackItem item : this.items){
			if(item.getType().isEquipable())
				System.out.println(item.toString());
		}
		System.out.println("===========================================================");
	}
	

	/**
	 * when the player removes an item from his inventory
	 * @param item
	 * @return if the item has been removed
	 */
	public boolean dropItem(Item item){
		if(isPresent(item)){
			items.remove(items.indexOf(searchItem(item)));
			return true;
		}
		return false;
	}
	
	/**
	 * @param the ItemType
	 * @return if the inventory contains the item
	 */
	public boolean isPresent(Item item){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getType().equals(item))
				return true;
		}
		return false;
	}
	
	/**
	 * @param the ItemType
	 * @return the item
	 */
	public StackItem searchItem(Item item){
		for(int i=0;i<items.size();i++){
			if(items.get(i).getType().equals(item))
				return items.get(i);
		}
		return null;
	}
	
	/**
	 * update the number of item in the inventory when the player uses one
	 * @param the item
	 * @return if the item has been used
	 */
	public boolean useItem(Item item,int quantity){
		StackItem itemToUse = getItemByType(item);
		if(itemToUse!=null && item.isEdible()){
			try {
				itemToUse.updateQuantity(-quantity);
				System.out.println("quuannnt "+itemToUse.getQuantity());
			} catch (MaxStacksException e) {
				e.printStackTrace();
			}
			return true;
		}
		return false;
	}
	
	public String toString(){
		String list ="";
		for(int i=0;i<items.size();i++){
			list+=items.get(i).toString()+"\n";
		}
		return list;
	}
	
	/**
	 * @param the item
	 * @return the item which is searching by the player
	 */
	public StackItem getItemByType(Item item){
		if(isPresent(item))
			return searchItem(item);
		return null;	
	}
	
	
	/**
	 * Browse all the items in the inventory to calculate the total weight of items
	 * @return if the inventory is full
	 */
	public boolean isFull(){
		return getCurrentWeight() >= maxWeight;
	}
	
	
	/**
	 * Browse all the inventory to calculate the total weight
	 * @return the total weight of the inventory
	 */
	public int getCurrentWeight(){
		int totalWeight=0;
		for(StackItem item: items){
			totalWeight+=item.getType().getWeight()*item.getQuantity();
		}
		return totalWeight;
	}
	
	/**
	 * Add to the current inventory all the items of the list in param 
	 * If the inventory contains items of the list, it will update its quantity
	 * @param list to add at the inventory
	 */
	public void addListToInventory(List<StackItem> listToAdd)throws FullInventoryException{
		for(StackItem itemToAdd : listToAdd){
			if(isPresent(itemToAdd.getType()))	{
				try {
					searchItem(itemToAdd.getType()).updateQuantity(itemToAdd.getQuantity());
				} catch (MaxStacksException e) {
					e.printStackTrace();
				}
				listToAdd.remove(itemToAdd);
			}
		}
		this.items.addAll(listToAdd);
	}
	
	
	// ========================== GETTERS AND SETTERS =============================
	
	/**
	 * @param maxWeight
	 */
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	/**
	 * @return the list of items of the inventory
	 */
	public List<StackItem> getItems() {
		return items;
	}

}

package dungeon.items;

import java.util.ArrayList;
import java.util.List;

import dungeon.exceptions.FullInventoryException;
import dungeon.exceptions.MaxStacksException;
import dungeon.utils.Constants;

/**
 * @author Loic
 * Inventory contains a list of items with a max weight
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
		this.items = new ArrayList<StackItem>();
		this.maxWeight=maxWeight;
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
				items.get(getIdxOfItem(item)).updateQuantity(item.getQuantity());
			} catch (MaxStacksException e) {
				e.printStackTrace();
			}
		else
			this.items.add(item);
	}
	
	/**
	 * @param item
	 * @return the idx of the item in the list
	 */
	public int getIdxOfItem(StackItem item){
		for(int i =0;i<items.size();i++){
			if(item.getType().equals(items.get(i).getType()))
				return i;
		}
		return -1;
	}
	
	

	/**
	 * when the player removes an item from his inventory
	 * @param item
	 * @return if the item has been removed
	 */
	public boolean dropItem(Item item){
		if(isPresent(item)){
			items.remove(getIdxOfItem(searchItem(item)));
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
		return getCurrentWeight() <= maxWeight;
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
	public void addListToInventory(List<StackItem> listToAdd){
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
	
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	public List<StackItem> getItems() {
		return items;
	}

}

package dungeon.items;

import dungeon.exceptions.MaxStacksException;

/**
 * Represents an item with his quantity -- This is the elements of inventory
 * @author Loic
 * 
 */
public class StackItem {
	
	protected Item type;
	protected int quantityOfStack;


	/**
	 * @param type
	 * @throws MaxStacksException if quantity exceed the max quantity of a stack 
	 */
	public StackItem(Item type) throws MaxStacksException{
		this(type,1);
	}
	
	/**
	 * @param type
	 * @param quantity
	 * @throws MaxStacksException if quantity exceed the max quantity of a stack 
	 */
	public StackItem(Item type,int quantity) throws MaxStacksException{
		if(quantity>type.getMaxStack())
			throw new MaxStacksException();
		else {
			this.type=type;
			this.quantityOfStack=quantity;	
		}
	}
	

	/**
	 * Update the quantity of the stack and check if it exceed the max quantity of a stack
	 * @param quantity (negative number are allowed)
	 * @throws MaxStacksException
	 */
	public void updateQuantity(int quantity) throws MaxStacksException{
		if(quantity+quantityOfStack>type.getMaxStack())
			throw new MaxStacksException();
		this.quantityOfStack += quantity;
	}
	
	/**
	 * @return quantity of the stack
	 */
	public int getQuantity() {
		return quantityOfStack;
	}
	
	/**
	 * @return the weight for one item multiply by the quantity of the item
	 */
	public int getWeight(){
		return this.quantityOfStack*this.getType().getWeight();
	}


	/**
	 * @return type of the item
	 */
	public Item getType() {
		return type;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "- "+this.getType().toString()+" (x"+this.quantityOfStack+") -- Weight(individually) : "
					+this.getType().getWeight()+" -- Power : "+this.getType().getPower();
	}
}

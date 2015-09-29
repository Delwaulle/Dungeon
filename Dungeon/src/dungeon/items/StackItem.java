package dungeon.items;

import dungeon.exceptions.MaxStacksException;

public class StackItem {
	
	protected Item type;
	protected int idType;
	protected int quantityOfStack;


	public StackItem(Item type) throws MaxStacksException{
		this(type,1);
	}
	
	public StackItem(Item type,int quantity) throws MaxStacksException{
		if(quantity>type.getMaxStack())
			throw new MaxStacksException();
		else {
			System.out.println("yo");
			this.idType=getTypeId(type);
			this.type=type;
			this.quantityOfStack=quantity;	
		}
	}
	

	public void updateQuantity(int quantity) throws MaxStacksException{
		if(quantity+quantityOfStack>type.getMaxStack())
			throw new MaxStacksException();
		this.quantityOfStack += quantity;
	}
	
	public int getQuantity() {
		return quantityOfStack;
	}
	
	
	public int getTypeId(Item type){
		 return type.getId();
	}
	
	public int getWeight(){
		System.out.println(this.getType().name());
		return this.quantityOfStack*this.getType().getWeight();
	}


	public Item getType() {
		return type;
	}

	public String toString(){
		return this.getType().toString();
	}
}

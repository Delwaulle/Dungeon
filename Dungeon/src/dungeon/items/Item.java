package dungeon.items;

public abstract class Item {
	
	protected int quantity=1;
	protected String name;

	public String getName() {
		return name;
	}

	public Item(String name){
		this.name=name;
	}
	
	public Item(String name,int quantity){
		this.name=name;
		this.quantity=quantity;
	}

	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public abstract String toString();
}

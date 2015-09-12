package game;

public abstract class Item {
	
	protected int quantity=1;
	protected String name;

	public String getName() {
		return name;
	}

	public Item(String name){
		this.name=name;
	}

	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}
	
	public abstract String toString();
}

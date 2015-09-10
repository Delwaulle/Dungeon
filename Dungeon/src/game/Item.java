package game;

public class Item {
	
	protected int quantity=1;
	protected String name;

	public String getName() {
		return name;
	}



	public void updateQuantity(int quantity) {
		this.quantity += quantity;
	}
}

package game;

public class Potion extends Item{
	

	private int power;
	
	public Potion(String name,int power) {
		super(name);
		this.power=power;
	}
	
	public Potion(String name,int power,int quantity) {
		super(name,quantity);
		this.power=power;
	}

	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		this.power = power;
	}
	
	public String toString(){
		return this.name+" (x"+this.quantity+") - Power : "+
				this.power;
	}

}

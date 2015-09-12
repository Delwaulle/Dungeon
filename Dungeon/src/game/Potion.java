package game;

public class Potion extends Item{
	
	public Potion(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	private int power;
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

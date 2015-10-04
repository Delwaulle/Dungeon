package dungeon.game;

public class Trap {
	
	private String name;
	private int power;

	public Trap(TrapEnum trap) {
		this.setName(trap.getName());
		this.setPower(trap.getPower());
	}
	
	public Trap(String name, int power){
		this.setName(name);
		this.setPower(power);
	}


	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}
}

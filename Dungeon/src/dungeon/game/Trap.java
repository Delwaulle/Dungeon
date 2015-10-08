package dungeon.game;

/**
 * @author Camille
 * Trap impose damages to the character who go in
 */
public class Trap {
	
	private String name;
	private int power;

	/**
	 * @param trap
	 */
	public Trap(TrapEnum trap) {
		this.setName(trap.getName());
		this.setPower(trap.getPower());
	}
	
	
	/**
	 * activate the trap
	 */
	public void activate(Player player){
		System.out.println("You get hit from " + this.getName() +" !");
		System.out.println("You lose " + this.getPower() + " HP");
		player.getHit(this.getPower());
	}


	/**
	 * @return name of the trap
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return power of the trap
	 */
	public int getPower() {
		return power;
	}

	/**
	 * @param power
	 */
	public void setPower(int power) {
		this.power = power;
	}
}

package dungeon.game;

public class Trap {
	
	private Player player;
	
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

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
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
	
	public void activate(){
		this.player.getHit(power);
		System.out.println("You get hit from " + this.getName() +" !");
		System.out.println("You lose " + this.getPower() + " HP");
		System.out.println("You have now " + this.player.getCurrentHealth() + " HP");
	}

}

package dungeon.level;

import dungeon.game.Trap;
import dungeon.game.TrapEnum;

/**
 * this class is for a basic/normal room without monster, chest or trap and this
 * is not the entrance or the exit
 * 
 * @author fguilbert
 * 
 */
public class TrapRoom extends Room {

	protected String description;
	protected Trap trap;

	public TrapRoom(String name, Level level) {
		super(name, level);
		this.trap = new Trap(TrapEnum.GAZ);
	}
	
	public TrapRoom(String name, Trap trap, Level level){
		super(name, level);
		this.trap = trap;
	}

	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayInformation() {
		System.out.println("You are in " + this.name);
	}

	@Override
	public void action() {
		this.trap.setPlayer(player); // player comes from the Room super class.
										// May be it should be better to get
										// player from GameBoard
		this.trap.activate();
	}

	@Override
	public void setDescription(String description) {
		this.description = description;

	}

	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Trap getTrap(){
		return this.trap;
	}
	
	public void setTrap(Trap trap){
		this.trap = trap;
	}

}

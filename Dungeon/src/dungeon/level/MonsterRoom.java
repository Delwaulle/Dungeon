package dungeon.level;

import dungeon.game.Battle;
import dungeon.game.Character;
import dungeon.game.GameBoard;
import dungeon.game.Monster;
import dungeon.game.Player;
import dungeon.utils.SecureInput;

/**
 * a specific room in which one there is a monster
 * @author fguilbert
 * 
 */
public class MonsterRoom extends Room {

	private Monster monster;

	/**
	 * @param name
	 * @param level
	 */
	public MonsterRoom(String name,Level level) {
		super(name,level);
		this.monster = new Monster("Devil cat");
	}

	/**
	 * @param name
	 * @param monster
	 * @param level
	 */
	public MonsterRoom(String name, Monster monster,Level level) {
		super(name,level);
		this.monster = monster;
	}


	@Override
	public String getDirection() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void displayInformation() {
		// TODO Auto-generated method stub
	}

	@Override
	public void action() {
		if(!this.monster.isDead()){	
			System.out.println(monster.getName() + " blocks you the passage !");
			System.out.println("Enter \"1\" to try to kill the monster");
			System.out.println("Enter \"2\" to flee the fight and go back to the previous room");

			int answer = SecureInput.getIntSecureInput();
			switch (answer) {
			case 1:
				Battle battle = new Battle(GameBoard.player, this.monster);
				Character winner =battle.fight();
				if (winner.getClass()==Player.class) {
					this.displayDirections();
				} else {
					this.level.goToEntrance();//lose go back to entrance
				}
				break;

			case 2:
				// go back to the previous room
				this.level.goToPreviousRoom();
				break;

			default:
				System.out.println("I don't know what you mean");
				action();
			}
		}
	}

	@Override
	public void setDescription(String description) {
		// TODO Auto-generated method stub

	}

}

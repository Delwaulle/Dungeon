package dungeon.game;


/**
 * All the components for having a monster
 * @author fguilbert
 * 
 */
public class Monster extends Character{
	
	/**
	 * We create a monster with its state (not dead ^^),
	 * its strength and its life (HP:HealthPoints)
	 * @param name
	 */
	public Monster(MonsterEnum monster){
		super(monster.getName());
		this.damages = monster.getPower();
		this.maxHealth = monster.getHealth();
		this.currentHealth=maxHealth;
	}
	
	@Override
	public void die() {
		this.dead=true;
		System.out.println("Good job, you have killed "+this.getName());
		System.out.println("Let's see your drop !");
		String drop=this.getInventory().toString();
		if(drop=="")
			System.out.println("Nothing to drop !");
		else
			System.out.println(drop);
		GameBoard.player.getDrop(this);
	}


}

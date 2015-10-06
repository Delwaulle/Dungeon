package dungeon.game;

import dungeon.utils.Constants;


/**
 * All the components for having a monster
 * @author fguilbert
 * 
 */
public class Monster extends Character{
	
	private MonsterEnum monster;
	
	/**
	 * We create a monster with its state (not dead ^^),
	 * its strength and its life (HP:HealthPoints)
	 * @param name
	 */
	public Monster(MonsterEnum monster,int level){
		super(monster.getName());
		this.monster=monster;
		initializeCaracteristics(level);
	
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

	@Override
	public void initializeCaracteristics(int level) {
		this.damages = this.monster.getPower()+(2*level+level);
		this.maxHealth = this.monster.getHealth()+(2*level+(int)level/2);
		this.pourcentCriticalHit=Constants.BASIC_POURCENTAGE_OF_CRITICAL_HIT+calculatePourcentCriticalHitByLevel(level);
		this.powerOfCriticalHit=Constants.BASIC_POWER_OF_CRITICAL_HIT+(2*level);
		
		this.currentHealth=maxHealth;		
	}


}

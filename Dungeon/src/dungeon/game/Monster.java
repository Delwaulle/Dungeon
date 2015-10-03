package dungeon.game;


import dungeon.items.Inventory;

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
		this.inventory=new Inventory();
	}
	
	/**
	 * We create a monster with its state,
	 * its strength and its life (HP:HealthPoints)
	 * But, here, we specify its strength
	 * @param name
	 * @param damages
	 */
	public Monster (String name,int damages){
		super(name);
		this.damages=damages;
		this.maxHealth = 5;
	}

	/**
	 * We create a monster with its state,
	 * its strength and its life (HP:HealthPoints)
	 * But, here, we specify its strength
	 * @param name
	 * @param damages
	 * @param health
	 */
	public Monster (String name,int damages,int health){
		super(name);
		this.damages=damages;
		this.maxHealth = health;
	}

}

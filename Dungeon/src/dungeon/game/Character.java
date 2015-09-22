package dungeon.game;

public class Character {
	
	protected String name;
	protected int damages, maxHealth,currentHealth;
	protected int pourcentCriticalHit=50;
	protected int powerOfCriticalHit=2;
	protected boolean dead;
	
	
	public Character(String name){
		this.name=name;
		this.dead=false;
	}
	
	/**
	 * the character is attacking another character
	 * @return the damages
	 */
	public int attack(){
		if(isCriticalHit()){
			System.out.println("Critical hit !");
			return this.damages*powerOfCriticalHit;
		}
		//normal hit
		return this.damages;
	}
		
	
	/**
	 * @return if the character is making a critical hit or not
	 */
	public boolean isCriticalHit(){
		int random = (int)(Math.random() * 100)+1;
		if(random<=this.pourcentCriticalHit)
			return true;
		return false;
	}
	
	
	/**
	 * the character dies
	 */
	public void die(){
		this.dead = true;
	}
	
	
	/**
	 * @return the state of the character (dead or not ?)
	 */
	public boolean isDead(){
		return this.dead;
	}
	
	
	
	/**
	 * update the health of the character with the damages
	 * @param dmg
	 */
	public void getHit(int dmg){
		this.currentHealth -= dmg;
		if(this.currentHealth <= 0)
			this.dead = true;
	}
	
	
	
	
	/*
	* ===========================================================================
	* 						Getters and setters
	*/
	

	/**
	 * @return the name of the character (example: "Camille")
	 */
	public String getName() {
		return name;
	}

	/**
	 * We choose the name of the character (example: "Camille")
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	

	/**
	 * @return max health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * @param max health
	 */
	public void setMaxHealth(int maxHealth) {
		this.maxHealth = maxHealth;
	}

	/**
	 * @param damages
	 */
	public void setDamages(int damages) {
		this.damages = damages;
	}
	

	/**
	 * @return the damages 
	 */
	public int getDamages(){
		return this.damages;
	}
	
	/**
	 * @return the luck to make a critical hit
	 */
	public int getPourcentCriticalHit() {
		return pourcentCriticalHit;
	}

	/**
	 * @param pourcentCriticalHit
	 */
	public void setPourcentCriticalHit(int pourcentCriticalHit) {
		this.pourcentCriticalHit = pourcentCriticalHit;
	}

	/**
	 * @return the power of the character during a critical hit
	 */
	public int getPowerOfCriticalHit() {
		return powerOfCriticalHit;
	}

	/**
	 * @param powerOfCriticalHit
	 */
	public void setPowerOfCriticalHit(int powerOfCriticalHit) {
		this.powerOfCriticalHit = powerOfCriticalHit;
	}
	
	/**
	 * @return lives
	 */
	public int getCurrentHealth() {
		return currentHealth;
	}

	/**
	 * @param lives
	 */
	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	


}

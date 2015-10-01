package dungeon.items;

import dungeon.utils.Constants;

/**
 * Enum of all possible items in the game
 * @author Loïc
 *
 */
public enum Item {
	
	/*
	 * POTIONS -- CONSUMABLES
	 *
	 */
	HEALTH_POTION(0,10,1,1),
	STRENGH_POTION(1,10,1,1),

	/*
	 * WEAPONS
	 *
	 */
	
	WOODEN_SWORD(2,1,5,2),
	IRON_SWORD(3,1,10,5),
	GOLDEN_SWORD(4,1,15,10),
	DIAMOND_SWORD(5,1,20,15),
	
	/*
	 * KEYS
	 * 
	 */
	SAMPLE_KEY(6,Constants.MAX_KEYS_BY_LEVEL,1);
	;
	

	private final int id;
	private final int weight;
	private final int maxStack;
	private final int power;


	/**
	 * @param id
	 */
	private Item(final int id) {
        this(id, 1);
    }

    /**
     * @param id
     * @param stack
     */
    private Item(final int id, final int stack) {
        this(id, stack, 1);
    }

    /**
     * @param id
     * @param stack
     * @param weight
     */
    private Item(final int id, final int stack, final int weight) {
        this(id,stack,weight,0);
    }
    
    /**
     * @param id
     * @param stack
     * @param weight
     * @param power
     */
    private Item(final int id, final int stack, final int weight,int power){
    	this.id=id;
        this.maxStack=stack;
        this.weight=weight;
        this.power=power;
    }
    
    /**
	 * @param value
	 * @return if the value is an element of the Item's enum
	 */
	public static boolean isValidItemEnum(String value){
		for (Item item : values()) {
	        if(item.name().equals(value))
	           return true;
	    }
	    return false;
	}
    

     
    // ================== GETTERS AND SETTERS ======================
    
    /**
     * Checks if this item is edible.
     * @return true if this item is edible.
     */
    public boolean isEdible() {
    	switch (this) {
          case HEALTH_POTION:
          case STRENGH_POTION:
              return true;
          default:
              return false;
    	}
    }
    
    /**
     * Checks if this item is equipable.
     * @return true if this item is equipable.
     */
    public boolean isEquipable(){
    	switch (this) {
    		case WOODEN_SWORD:
    		case IRON_SWORD:
    		case GOLDEN_SWORD:
    		case DIAMOND_SWORD:
    		return true;
        default:
            return false;
    	}
    }
    
    public String toString(){
		return "- "+this.name()+" -- Weight : "
			+this.weight+" -- Power : "+this.power;
    }
    
	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return maxStack
	 */
	public int getMaxStack() {
		return maxStack;
	}

	/**
	 * @return weight
	 */
	public int getWeight() {
		return weight;
	}
	
	
	/**
	 * @return power
	 */
	public int getPower() {
		return power;
	}
}

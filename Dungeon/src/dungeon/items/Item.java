package dungeon.items;

import dungeon.utils.Constants;

public enum Item {
	
	/*
	 * POTIONS -- CONSUMABLES
	 * Id : 0 to 9
	 */
	HEALTH_POTION(0,10,1,1),
	STRENGH_POTION(1,10,1,1),

	/*
	 * WEAPONS
	 * Id : 10 to 49
	 */
	
	WOODEN_SWORD(10,1,5,2),
	IRON_SWORD(11,1,10,5),
	GOLDEN_SWORD(12,1,15,10),
	DIAMOND_SWORD(13,1,20,15),
	
	/*
	 * KEYS
	 * Id : 50 to 59
	 */
	SAMPLE_KEY(50,Constants.MAX_KEYS_BY_LEVEL,1);
	;
	

	private final int id;
	private final int weight;
	private final int maxStack;
	private final int power;


	private Item(final int id) {
        this(id, 1);
    }

    private Item(final int id, final int stack) {
        this(id, stack, 1);
    }

    private Item(final int id, final int stack, final int weight) {
        this(id,stack,weight,0);
    }
    
    private Item(final int id, final int stack, final int weight,int power){
    	this.id=id;
        this.maxStack=stack;
        this.weight=weight;
        this.power=power;
    }
    
    
    
    /**
     * Checks if this item is edible.
     *
     * @return true if this item is edible.
     */
    public boolean isEdible() {
        if(this.id>=0 && this.id<= 10) 
        	return true;
        return false;
    }
     

	public int getId() {
		return id;
	}

	public int getMaxStack() {
		return maxStack;
	}

	public int getWeight() {
		return weight;
	}
	
	
	public int getPower() {
		return power;
	}
}

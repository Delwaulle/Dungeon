package dungeon.utils;


/**
 * @author Loic
 * A sample class which contains all important constants of the project
 */
public final class Constants {
	
	/*
	* ITEMS
	*/
	public static final int MAX_KEYS_BY_LEVEL = 10;
	public static final int MAX_ITEM_RARITY=30;
	
	
	
	/*
	 * INVENTORY
	 */
	public static final int MAX_WEIGHT_INVENTORY =100;
	
	
	
	/*
	 * LEVELS
	 */
	public static  int MAX_LEVELS =10;
	
	
	
	/*
	 * DUNGEONS
	 */
	public static  int MAX_DUNGEONS =10;
	
	/*
	 * PLAYER
	 */
	public static final int BASIC_POWER = 5;
	public static final int BASIC_LIFE = 20;
	public static final int BASIC_POURCENTAGE_OF_CRITICAL_HIT=5;
	public static final int BASIC_POWER_OF_CRITICAL_HIT=5;
	public static final int MAX_POURCENT_CRITICAL_HIT=50;


	/*
	 * RANDOM
	 */
	public static final int MAX_RANDOM_ITEM= 3;
	public static final int MAX_RANDOM_FURNITURE=3;
	
	/**
	 * @param mAX_LEVELS
	 */
	public static void setMAX_LEVELS(int maxLevels) {
		MAX_LEVELS = maxLevels;
	}



	/**
	 * @param mAX_DUNGEONS
	 */
	public static void setMAX_DUNGEONS(int maxDungeons) {
		MAX_DUNGEONS = maxDungeons;
	}
}

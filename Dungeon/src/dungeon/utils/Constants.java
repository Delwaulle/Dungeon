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
	public static final int BASIC_POURCENTAGE_OF_CRITICAL_HIT=10;
	public static final int BASIC_POWER_OF_CRITICAL_HIT=5;
	public static final int MAX_POURCENT_CRITICAL_HIT=50;


	/**
	 * @param mAX_LEVELS
	 */
	public static void setMAX_LEVELS(int mAX_LEVELS) {
		MAX_LEVELS = mAX_LEVELS;
	}



	/**
	 * @param mAX_DUNGEONS
	 */
	public static void setMAX_DUNGEONS(int mAX_DUNGEONS) {
		MAX_DUNGEONS = mAX_DUNGEONS;
	}
}

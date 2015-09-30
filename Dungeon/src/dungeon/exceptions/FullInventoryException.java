package dungeon.exceptions;

/**
 * To catch exception when we try to add items to the inventory when it is full
 * @author Loic
 * 
 */
public class FullInventoryException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Catch an exception when the inventory is full
	 */
	public FullInventoryException(){
		super();
	}
}

package dungeon.exceptions;

/**
 * Catch an exception when we try to add quantity of an item while the stack is full
 * @author Loic
 * 
 */
public class MaxStacksException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Catch an exception when the stack is full
	 */
	public MaxStacksException(){
		super();
	}
}

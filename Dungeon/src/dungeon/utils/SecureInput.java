package dungeon.utils;

import java.util.Scanner;

/**
 * Secure the input according to the type of input
 * @author Loic
 *
 */
public class SecureInput {
	
	private static Scanner scanner=new Scanner(System.in);
	
	
	/**
	 * @return the next secure int
	 */
	public static int getIntSecureInput(){
		int intInput=0;
		while(true){
			try {
				intInput  = Integer.parseInt(scanner.nextLine());
		    	break;
		    } 
		    catch(NumberFormatException nfe) {
		    	System.out.println("Integers only, please.");
		    }
		}
		return intInput;
	}
	
	/**
	 * @return the next no empty String
	 */
	public static String getNoEmptyStringInput(){
		String input="";
		input=scanner.nextLine();
		if(input.equals("")){
			System.out.println("No empty String please");
			getNoEmptyStringInput();
		}
		return input;
	}

}

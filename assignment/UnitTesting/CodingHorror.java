/**
 * Qiufeng Du
 * 1439484
 */
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/**
 * Assignment 4 Part 1: Static Code Analysis <br />
 * The buggy {@code CodingHorror} source code
 */
public class CodingHorror {
	//Return value of String.replace(char, char) ignored in CodingHorror.main(String[])
	//Reason: The return value of the replacement was not stored.
	//Solution: Using the express: input = input.replace('e', 'o'); to store the return value
	
	//Dereference of the result of readLine() without nullcheck in CodingHorror.main(String[])
	//Reason: Did not check whether the input value is still null while doing the replacement
	//Solution: Use if else statement to check whether the input is null
	
	//Comparison of String objects using == or != in CodingHorror.main(String[]) 
	//Reason: Unless the strings are constants in the source file or the value of the string was 
	//interned using command: String.inter(). Two strings with same string values could represent
	//different different string object
	//Solution: Use object.equals() expression to replace ==
	
	//Logical error: when entered pool, it also shows User entered peel
	//Reason: When the input was "pool", the input string didn't do the replacement, but the string value of
	//the input was still "pool". So one single if else statement couldn't recognize whether the input was 
	//"pool", "peel", or something else.
	//Solution: Use if statement to check whether the original input is "pool"
    public static void main(String args[]) {
        // TODO: Assignment 4 Part 1 -- run FindBugs on the code

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String input = null;
        try {
            input = br.readLine();                  // e.g., peel
        } catch (IOException ioex) {
            System.err.println(ioex.getMessage());
        }
        if (input != null) {
        	if (input.equals("pool")) {
        		System.out.println("User entered something else");
        	}else {
        		input = input.replace('e', 'o');
                
            	if (input.equals("pool")) {
            		System.out.println("User entered peel.");
            	} else {
            		System.out.println("User entered something else.");
            	}
        	}
        	
        }
    }
}

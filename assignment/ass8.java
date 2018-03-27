/**
 * Qiufeng Du
 * 1439484
 */
/**
 * 1.	B is more understandable
 * Since the 9.81 are not supposed to be changed
 *  during the whole execution, it could be either 
 *  a direct number (like 9.81) in a or by using 
 *  “static final”. However, in B, by using 
 *  the “static final”, even without any coding experience, 
 *  people could still know that 9.81 is g in 
 *  this case. 
 */
public class ass8 {
	//Inline Temp
	public int funny(int a, int b) {
		if(a*b > 100) {
			return a*b*0.95;
		}
		else {
			return a*b*0.25;
		}
	}
	
	//Extract Method Followed by Replace Temp with Query
	public int funny(int a, int b) {
        if (temp(a, b) > 100) {
            return temp(a, b) * 0.95;
        } 
        else {
            return temp(a, b) * 0.25;
        }
    }
	int temp(int a, int b) {
		return a*b;
	}
	/**
	 * 2. The inline Temp is more appropriate in this case. 
	 * It is obviously that the multiply relationship between
	 * a and b are more clearly to see by using Inline Temp.
	 * Comparing to Inline Temp, the second function is redundant.
	 */
	
}

/**
 * 3. Replace Error Code with Exception
 * The second code is better because by using exception,
 * the program knows immediately that there is an error between
 * amountToBeWithdrawn and currentBalance. Without using exception directly, 
 * programer in A will need to deal with -1 later. 
 * 
 * Using exceptions programer also could implement its own method in the exception.
**/

/**
 * 4. A is better when the variable is fix, has certain meaning and need to be used
 * multiple times in the code. It is better to use the "final int" to define what is 
 * offset instead of remembering the value of offset which is 128.
 * 
 * B is better when the variable is not fix or will not be needed in the future. 
 * It is redundant to create a variable but only use it once. Moreover, if the value is 
 * not fixed, by giving it a "name", we need to change the value of the name later, which is
 * not convenient. 
 **/

/**
 * 5. Move Method Refactoring Pattern
 * Impact: A: output is 10			B: output is 20
 **/
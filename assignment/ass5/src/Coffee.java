/**Qiufeng Du
 * 1439484
 */
/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code Coffee} class
 */

public class Coffee implements Comparable<Coffee> {
    private int strength;
    // The strength of the coffee
    public Coffee(int strength) {
    	this.strength = strength;
    }
    public int return_Coffee() {
    	return strength;
    }
    public int compareTo(Coffee newOne) {
        if (this.strength > newOne.return_Coffee()){
        	return 1;
        }
        else if (this.strength < newOne.return_Coffee()){
        	return -1;
        }
        else return 0;
        
    }
    // TODO: Assignment 5 Part 1 -- complete this class
}

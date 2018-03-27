/**
 * Qiufeng Du
 * 1439484
 */
/**
 * Assignment 4 Part 2: Unit Testing <br />
 * The calculator to run the test cases
 */
// TODO: Assignment 4 Part 2 -- Create the Calculator here

public class Calculator{
	public Double add(double i, double j){
		double result = i+j;
		return result;	
	}
	public Double divide(double i, double j){
		double result = i/j;
		return result;	
	}
	public Double multiply(double i, double j){
		double result = i*j;
		return result;	
	}
	public Double[] getRoots(double a, double b,double c) {
		double temp1 = Math.sqrt(b * b - 4 * a * c);
		 
        Double root1 = (-b +  temp1) / (2*a) ;
        Double root2 = (-b -  temp1) / (2*a) ;
        if (root1.equals(root2) && !root1.isNaN()) {
        	Double[] roots = new Double[] {root1};
        	return roots;
        }
        else {
        	Double[] roots = new Double[] {root1, root2};
        	return roots;
        }
        
	}
	public Double subtract(double i, double j){
		double result = i-j;
		return result;	
	}
	public Double SquareRoot(double i){
		Double result = Math.sqrt(i);
		return result;	
	}
};
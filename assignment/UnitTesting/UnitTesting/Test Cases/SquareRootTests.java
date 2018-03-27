import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * JUnit test class for solving square roots
 */
public class SquareRootTests {

    // TODO: Assignment 4 Part 2 -- Checkpoint4
	private Calculator calc;

    @Before public void setUp() throws Exception {
        calc = new Calculator();
    }

    @After public void tearDown() throws Exception {
    }
    
    @Test public void testRandomPositiveSquareRoot() {
        // You cannot use the Math.sqrt() function in the test!
    	double a = Math.random();
    	double b = calc.SquareRoot(a)*calc.SquareRoot(a);
    	assertEquals(Double.valueOf(b), Double.valueOf(a),0.000001);
    }

    @Test public void testRandomNegitiveSquareRoot() {
        // The result should be a complex number i.e. Double.isNaN()
    	double a = Math.random()*(-1);
    	assertTrue(calc.SquareRoot(a).isNaN());
    }

    @Test public void testSquareRootofZero() {
        // You cannot use the Math.sqrt() function in the test!
    	double a = 0;
    	assertEquals(Double.valueOf(calc.SquareRoot(a)), Double.valueOf(a));
    }

    @Test public void testSquareRootofOne() {
        // You cannot use the Math.sqrt() function in the test!
    	double a = 1;
    	assertEquals(Double.valueOf(calc.SquareRoot(a)), Double.valueOf(a));
    }

}

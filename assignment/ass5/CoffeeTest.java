/**Qiufeng Du
 * 1439484
 */
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
/**
 * Assignment 5: Interfaces <br />
 * Part 1: The {@code CoffeeTest} class
 */
public class CoffeeTest {
	List<Coffee> coffees = new ArrayList<Coffee>();
	@Before public void setUp() throws Exception{
        coffees.add(new Coffee(10));
        coffees.add(new Coffee(2));
        coffees.add(new Coffee(10));
        coffees.add(new Coffee(20));
        coffees.add(new Coffee(5));
        Collections.sort(coffees);
	}
	@After public void tearDown() throws Exception{
		
	}
	@Test public void testComparable() {
        System.out.println("Coffees in order of strength:");
        for (Coffee type : coffees) {
        	//System.out.println(coffees.get(4).return_Coffee());
            System.out.println(type);
        }
    }
}


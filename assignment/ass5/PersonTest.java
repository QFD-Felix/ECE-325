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
 * Part 3: The {@code PersonTest} class
 */
public class PersonTest {
	Set<Person> persons = new TreeSet<Person>(new PersonComparator());
	@Before public void setUp() throws Exception{
		persons.add(new Person(32));
        persons.add(new Person(17));
        persons.add(new Person(13));
        persons.add(new Person(35));
        persons.add(new Person(27));
	}
	@After public void tearDown() throws Exception{
		
	}
	@Test public void testComparable() {
		Iterator<Person> iter = persons.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
	}
    
}

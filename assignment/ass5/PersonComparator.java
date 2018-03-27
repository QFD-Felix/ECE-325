/**Qiufeng Du
 * 1439484
 */
import java.util.*;
public class PersonComparator implements Comparator<Person>{
	public PersonComparator() {
	}
	public int compare(Person p1, Person p2) {
		if (p1.return_order() > p2.return_order()){
        	return 1;
        }
		else if (p1.return_order() < p2.return_order()){
        	return -1;
        }
		else return 0;
	}
	
}

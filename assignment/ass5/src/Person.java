/**Qiufeng Du
 * 1439484
 */
public class Person {
	private int order;
	public Person(int order) {
		this.order = order;
	}
	public int return_order() {
		return order;
	}
	 public int compareTo(Person newOne) {
		 if (this.order > newOne.return_order()){
	        	return 1;
	        }
		 else if (this.order < newOne.return_order()){
	        	return -1;
	        }
		 else return 0;
	 }
}

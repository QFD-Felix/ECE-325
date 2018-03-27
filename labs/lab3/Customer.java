
public class Customer extends Person implements Printable {

	private double projPrice;

	public Customer(String name, double projPrice) {
		super(name);
		this.projPrice = projPrice;
		// TODO Auto-generated constructor stub
	}
	public double get_projPrice() {
		return projPrice;
	}
	@Override
	public String PrintInfo() {
		// TODO Auto-generated method stub
		return get_name()+" "+get_projPrice();
	}

}

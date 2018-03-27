
public class Empolyee extends Person {

	private double baseSalary;

	public Empolyee(String name, double baseSalary) {
		super(name);
		this.baseSalary = baseSalary;
	}
	public double get_baseSalary() {
		return baseSalary;
	}
	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		else if ((obj == null)||(obj.getClass() != this.getClass())) {
			return false;
		}
		else if (super.equals(obj) == false) {
			return false;
		}
		else {
			Empolyee sample = (Empolyee)obj;
			return baseSalary == sample.get_baseSalary();
		}
	}
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 31*hash^Double.valueOf(baseSalary).hashCode();
		return hash;
	}
}

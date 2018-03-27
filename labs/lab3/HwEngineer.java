
public class HwEngineer extends Empolyee implements SalaryRaisable{
	public HwEngineer(String name, double baseSalary) {
		super(name,baseSalary);
	}
	@Override
	public double RaiseSalary() {
		// TODO Auto-generated method stub
		return get_baseSalary()+ get_baseSalary()*0.18;
	}
	
}

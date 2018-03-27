import java.util.*;
public class ProjManager extends SwEngineer implements Printable,SalaryRaisable {
	
	private Date projDeadline;

    public ProjManager(String name, double baseSalary, String projName, Date projDeadline) {
        super(name, baseSalary, projName);
        this.projDeadline = projDeadline;
    }
    public Date get_projDeadline() {
    	return projDeadline;
    }
	@Override
	public double RaiseSalary() {
		// TODO Auto-generated method stub
		return get_baseSalary()+ get_baseSalary()*0.24;
	}

	@Override
	public String PrintInfo() {
		// TODO Auto-generated method stub
		return get_name()+" "+get_projName()+" "+RaiseSalary()+" "+get_projDeadline();
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
			ProjManager sample = (ProjManager)obj;
			return Objects.equals(projDeadline, sample.get_projDeadline());
		}
	}
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 50*hash^(null == projDeadline ? 0 : projDeadline.hashCode());
		return hash;
	}

}

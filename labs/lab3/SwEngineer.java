public class SwEngineer extends Empolyee{
	private String projName;
	public SwEngineer(String name, double baseSalary, String projName) {
        super(name, baseSalary);
        this.projName = projName;
    }
	public String get_projName() {
		return projName;
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
			SwEngineer sample = (SwEngineer)obj;
			return projName.equals(sample.get_projName());
		}
	}
	@Override
	public int hashCode() {
		int hash = super.hashCode();
		hash = 31*hash^(null == projName ? 0 : projName.hashCode());
		return hash;
	}
}

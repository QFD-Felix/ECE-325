public class Person {

	private String name;

	public Person(String name) {
		this.name = name;
		// TODO Auto-generated constructor stub
	}
	public String get_name() {
		return name;
	}
	@Override
	public boolean equals (Object obj) {
		if (this == obj) {
			return true;
		}
		else if ((obj == null)||(obj.getClass() != this.getClass())) {
			return false;
		}
		else {
			Person sample = (Person)obj;
			return name.equals(sample.get_name());
		}
	}
	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31*hash^name.hashCode();
		return hash;
	}
}

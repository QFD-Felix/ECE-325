
public class classTest {
	public static void main(String[] args) {
		Customer cus = new Customer("aaa",5);
		System.out.println(cus.PrintInfo());
		
		ProjManager pro = new ProjManager ("bbb",6000,"project name",null);
		System.out.println(pro.PrintInfo());
		
		SwEngineer sw0 = new SwEngineer("123",456,"name");
		SwEngineer sw1 = new SwEngineer("123",456,"name");
		SwEngineer sw2 = new SwEngineer("1234",456,"name");
		System.out.println(sw0.equals(sw1));
		System.out.println(sw0.equals(sw2));
		
		ProjManager pj0 = new ProjManager("1234",567,"name1",null);
		ProjManager pj1 = new ProjManager("1234",567,"name1",null);
		ProjManager pj2 = new ProjManager("12345",567,"name1",null);
		ProjManager pj3 = new ProjManager("1234",5678,"name1",null);
		ProjManager pj4 = new ProjManager("1234",567,"name11",null);
		System.out.println(pj0.equals(pj1));
		System.out.println(pj0.equals(pj2));
		System.out.println(pj0.equals(pj3));
		System.out.println(pj0.equals(pj4));
		
		HwEngineer hw0 = new HwEngineer("1234", 567);
        HwEngineer hw1 = new HwEngineer("1234", 567);
        HwEngineer hw2 = new HwEngineer("1234", 5678);
        System.out.println(hw0.equals(hw1));
        System.out.println(hw0.equals(hw2));
        
        System.out.println(hw0.equals(pj0));
        System.out.println(pj0.equals(hw0));
		
		

	}
}

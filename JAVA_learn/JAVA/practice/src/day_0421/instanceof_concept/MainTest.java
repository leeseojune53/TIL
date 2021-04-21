package day_0421.instanceof_concept;

public class MainTest {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		driver.drive(new Bus());
		System.out.println();
		
		driver.drive(new Taxi());

	}

}

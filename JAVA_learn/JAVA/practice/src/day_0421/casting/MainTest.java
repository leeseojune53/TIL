package day_0421.casting;

public class MainTest {

	public static void main(String[] args) {
		Vehicle vehicle = new Bus();
		
		vehicle.run();
		//vehicle.checkFare();
		
		Bus bus = (Bus) vehicle;
		bus.run();
		bus.checkFare();

	}

}

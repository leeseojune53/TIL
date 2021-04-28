package day_0428.a2;

public class MainTest {
	
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		
		anony.field.turnOn();
		
		anony.method1();
		
		anony.method2(new RemoteControl() {
			
			@Override
			public void turnOn() {
				System.out.println("SmartTV를 켭니다.");
				
			}
			
			@Override
			public void turnOff() {
				System.out.println("SmartTV를 끕니다.");
				
			}
		});
	}

}

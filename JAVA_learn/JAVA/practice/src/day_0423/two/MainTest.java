package day_0423.two;

public class MainTest {

	public static void main(String[] args) {
		A a = new A();
		
		A.B b = a.new B();
		b.field1 = 3;
		b.mehtod1();
		
		A.C c = new A.C();
		c.field1 = 3;
		c.method1();
		
		A.C.field2 = 3;
		A.C.method2();
		
		a.method();
	}

}

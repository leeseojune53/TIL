package day_0414;

public class Test {

	public static void main(String[] args) {
		A a1 = new A();
		A a = new B();
		
		B b = new B();
		B b1 = (B)a1;
		B b2 = (B)a;
	}
	
}

class A {
	
}

class B extends A {
	
}
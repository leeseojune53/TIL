package day_0423.two;

public class A {
	A() { System.out.println("A 객체가 생성됨"); }
	
	class B {
		B() {
			System.out.println("B 객체가 생성됨");
		}
		
		int field1;
		void mehtod1() {}
		
//		static int field2;
//		static void mehtod2();
	}
	
	static class C {
		C() { System.out.println("C 객체가 생성됨"); }
		int field1;
		void method1() {}
		
		static int field2;
		static void method2() {}
	}
	
	void method() {
		class D {
			D() { System.out.println("D 객체가 생성됨"); }
			int field1;
			void method1() {}
		}
		D d = new D();
		d.field1 = 3;
		d.method1();
	}

}

package day_0421.default_extends;

public interface ParentInterface {
	
	public void method1();
	
	public default void method2() {
		System.out.println("P_method2() 실행");
	}

}

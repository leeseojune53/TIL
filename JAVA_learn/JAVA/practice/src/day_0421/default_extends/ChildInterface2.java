package day_0421.default_extends;

public interface ChildInterface2 extends ParentInterface{
	
	@Override
	public default void method2() {
		System.out.println("C2_method2() 실행");
	}
	
	public void method3();
	
}

package test_2114;

public class Person extends Animal{
	
	private int age;

	public Person(int fullness, String name, int age) {
		super(fullness, name);
		this.age = age;
	}
	
	public void old() {
		System.out.println("Person이 나이를 먹습니다.");
		++age;
	}

}

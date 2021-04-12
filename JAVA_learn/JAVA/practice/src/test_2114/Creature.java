package test_2114;

public class Creature {
	private String name;
	
	public Creature(String name) {
		this.name = name;
	}
	
	public void breath(Environment environment) {
		if(environment instanceof Oxygen) {
			((Oxygen)environment).use(10L);
		}
		System.out.println("Creature가 숨을 쉽니다.");
	}
	
	public void eat() {
		System.out.println("Creature가 음식을 먹습니다.");
	}

}

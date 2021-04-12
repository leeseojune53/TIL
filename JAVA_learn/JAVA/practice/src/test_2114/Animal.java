package test_2114;

public class Animal extends Creature{

	private int fullness;
	
	public Animal(int fullness, String name) {
		super(name);
		this.fullness = fullness;
	}
	
	@Override
	public void eat() {
		System.out.println("Animal이 음식을 먹습니다.");
		fullness+=10;
	}
	
	public void eat(String name) {
		System.out.println("Animal이 " + name + "를 먹습니다.");
		fullness+=10;
	}
	

}

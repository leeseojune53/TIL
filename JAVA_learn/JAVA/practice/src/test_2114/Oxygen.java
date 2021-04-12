package test_2114;

public class Oxygen extends Environment{
	
	private long amount;

	public Oxygen(long amount, String name) {
		super(name);
		this.amount = amount;
	}
	
	public void use(long amount) {
		if(this.amount - amount > 0) {
			this.amount -= amount;
			System.out.println(amount + "의 산소를 사용하셨습니다.");
		}
		else System.out.println("산소가 부족합니다.");
	}

}

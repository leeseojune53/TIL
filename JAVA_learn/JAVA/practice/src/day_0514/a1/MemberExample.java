package day_0514.a1;

public class MemberExample {

	public static void main(String[] args) {
		Member original = new Member("password");
		
		Member cloned = original.getmember();
		cloned.password = "67890";
		
		System.out.println("복제 password: " + cloned.password);
		System.out.println("원본 객체의 password: " + original.password);
	}
	
}

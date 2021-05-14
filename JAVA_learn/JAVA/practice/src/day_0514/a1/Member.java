package day_0514.a1;

public class Member implements Cloneable {

	public String password;
	
	public Member(String password) {
		this.password = password;
	}
	
	public Member getmember() {
		Member cloned = null;
		try {
			cloned = (Member) clone();
		} catch(CloneNotSupportedException e) {}
		return cloned;
	}
	
	
	
}

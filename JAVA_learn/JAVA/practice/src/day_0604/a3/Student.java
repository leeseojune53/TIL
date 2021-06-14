package day_0604.a3;


public class Student {
	
	private int number;
	private String name;
	
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
	
	@Override
	public int hashCode() {
		return name.hashCode() + number;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Student) {
			Student member = (Student) obj;
			return member.name.equals(name) &&
					(member.number == number);
		} else {
			return false;
		}
	}

}

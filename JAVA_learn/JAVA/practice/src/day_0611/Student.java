package day_0611;

public class Student {
	
	private int stdNo;
	private String name;
	
	public Student(int stdNo, String name) {
		this.stdNo = stdNo;
		this.name = name;
	}
	
	public int getStdNo() {
		return stdNo;
	}
	
	@Override
	public int hashCode() {
		return stdNo;
	}
	
	@Override
	public boolean equals(Object o) {
		if(o instanceof Student) {
			return ((Student)o).getStdNo() == stdNo;
		}
		return false;
	}

}

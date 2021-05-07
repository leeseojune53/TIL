package day_0507.a1;

public class TryCatch {
	public static void main(String[] args) {
		try {
			Class claszz = Class.forName("java.lang.String2");
		}catch(ClassNotFoundException e) {
			System.out.println();
		}
	}
}

package practice;

public class Array03 {
	public static void main(String[] args) {
		String[] old1 = {"java", "array", "copy"};
		String[] new1 = new String[5];
		
		System.arraycopy(old1, 0, new1, 0, 3);
		
		for(String value : new1) {
			System.out.println(value);
		}
	}
}

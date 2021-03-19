package practice;

public class Method1 {
	
	public static void main(String[] args) {
		System.out.println(Method.sum(1,2,3,4));
	}

}

class Method {
	static String name, name2;
	
	static {
		name = "수완";
		name2 = "";
	}
	
	int a;
	
	
	static int sum(int ...x) {
		int s = 0;
		for(int i : x) {
			s+=i;
			System.out.println(i);
		}
		return s;
		
	}
}

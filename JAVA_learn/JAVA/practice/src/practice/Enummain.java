package practice;

public class Enummain {
	public static void main(String[] args) {
		Enum a = Enum.A;
		String name = a.name();
		System.out.println(name);
		System.out.println();
		
		int ordinal = a.ordinal();
		System.out.println(ordinal);
		System.out.println();
		
		Enum b = Enum.B;
		Enum d = Enum.D;
		System.out.println(b.compareTo(d));
		System.out.println(d.compareTo(b));
		System.out.println();
		
		String s = "E";
		Enum e = Enum.valueOf(s);
		System.out.println(e);
		System.out.println();
		
		Enum[] array = Enum.values();
		for(Enum aa : array) {
			System.out.println();
		}
		
	}
}

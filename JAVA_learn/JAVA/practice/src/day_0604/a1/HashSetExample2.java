package day_0604.a1;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample2 {
	
	public static void main(String[] args) {
	
		Set<Member> set = new HashSet<Member>();
		
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 20));
		
		System.out.println("총 객체수: " + set.size());
		
	}

}

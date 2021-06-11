package day_0604.a3;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample2 {
	
	public static void main(String[] args) {
		Map<Student, Integer> map = new HashMap<>();
		
		map.put(new Student(1, "자바킴"), 95);
		map.put(new Student(1, "자바킴"), 95);
		
		System.out.println("총 entry 수: " + map.size());
	}

}

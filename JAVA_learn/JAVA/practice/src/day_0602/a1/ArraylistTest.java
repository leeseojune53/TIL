package day_0602.a1;

import java.util.ArrayList;
import java.util.List;

public class ArraylistTest {
	
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		
		list.add("Java");
		list.add("Spring");
		list.add("Network");
		list.add(2, "Database");
		list.add("OS");
		
		int size = list.size();
		System.out.println("총 객체수: " + size);
		System.out.println();
		
		String skill = list.get(2);
		System.out.println("2: " + skill);
		System.out.println();
		
		for(String str : list) {
			System.out.println(list.indexOf(str) + ":" + str);
		}
		System.out.println();
		
		list.remove(2);
		list.remove(2);
		list.remove("Spring");
		
		for(String str : list) {
			System.out.println(list.indexOf(str) + ":" + str);
		}
		
		
	}

}

package day_0602.a4;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		
		set.add("Java");
		set.add("Spring");
		set.add("Network");
		set.add("Java");
		set.add("OS");
		
		int size = set.size();
		System.out.println("총 객체수: " + size);
		
		Iterator<String> iterator = set.iterator();
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.println("\t" + element);
		}
		set.remove("Spring");
		set.remove("OS");
		
		System.out.println("총 객체수: " + set.size());
	}

}

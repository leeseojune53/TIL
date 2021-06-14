package day_0602.a3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
	
	public static void main(String[] args) {
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new LinkedList<>();
		
		long startTime;
		long endTime;
		
		startTime = System.nanoTime();
		
		for(int i=0; i<10000; i++) {
			list1.add(0, String.valueOf(1));
		}
		
		endTime = System.nanoTime();
		
		System.out.println("ArrayList 걸린시간: " + (endTime - startTime) + " ns");
		
		startTime = System.nanoTime();
		
		for(int i=0; i<10000; i++) {
			list2.add(0, String.valueOf(1));
		}
		
		endTime = System.nanoTime();
		
		System.out.println("LinkedList 걸린시간: " + (endTime - startTime) + " ns");
		
	}

}

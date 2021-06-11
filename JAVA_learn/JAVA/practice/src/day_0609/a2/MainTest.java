package day_0609.a2;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class MainTest {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		TreeSet<String> treeSet = new TreeSet<>();
		TreeSet<TestClass<Integer>> testSet = new TreeSet<>();
		
		set.add("test");
		set.add("asdf");
		
		
		
		treeSet.addAll(set);
		
		Iterator<String> iterator = treeSet.iterator();
		
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		testSet.add(new TestClass<Integer>(1));
		testSet.add(new TestClass<Integer>(2));
		testSet.add(new TestClass<Integer>(-3));
		
		Iterator<TestClass<Integer>> iterator2 = testSet.iterator();
		
		while(iterator2.hasNext()) {
			System.out.println(iterator2.next().get());
		}
		
	}

}

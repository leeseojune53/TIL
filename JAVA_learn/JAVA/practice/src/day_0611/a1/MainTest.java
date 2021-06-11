package day_0611.a1;

import java.util.Iterator;
import java.util.TreeSet;

public class MainTest {
	
	public static void main(String[] args) {
		TreeSet<Fruit> treeSet = new TreeSet<>(new DescendingComparator());
		treeSet.add(new Fruit("포드", 3000));
		treeSet.add(new Fruit("수박", 10000));
		treeSet.add(new Fruit("딸기", 6000));
		
		Iterator<Fruit> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Fruit fruit = iterator.next();
			System.out.println(fruit.name + ":" + fruit.price);
		}
		
		Iterator<Fruit> ascendingSet = treeSet.descendingIterator();
		while(ascendingSet.hasNext()) {
			Fruit fruit = ascendingSet.next();
			System.out.println(fruit.name + ":" + fruit.price);
		}
		
	}

}

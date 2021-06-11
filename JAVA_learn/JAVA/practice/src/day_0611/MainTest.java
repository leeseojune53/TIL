package day_0611;

import java.util.Iterator;
import java.util.TreeSet;

public class MainTest {
	
	public static void main(String[] args) {
		TreeSet<Person> treeSet = new TreeSet<>();
		
		treeSet.add(new Person("홍길동", 45));
		treeSet.add(new Person("김자바", 25));
		treeSet.add(new Person("박지원", 31));
		
		Iterator<Person> iterator = treeSet.iterator();
		while(iterator.hasNext()) {
			Person person = iterator.next();
			System.out.println(person.name + ":" + person.age);
		}
	}

}

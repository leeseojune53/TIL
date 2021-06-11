package day_0609.a2;

public class TestClass<T extends Comparable<? super T>> implements Comparable<TestClass<T>>{
	
	private T value;
	
	public TestClass(T value) {
		this.value = value;
	}
	
	public T get() {
		return this.value;
	}

	@Override
	public int compareTo(TestClass<T> o) {
		return this.value.compareTo(o.get());
	}
	
}

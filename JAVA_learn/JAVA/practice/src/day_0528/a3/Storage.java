package day_0528.a3;

public interface Storage<T> {
	
	public void add(T item, int index);
	public T get(int index);
	
}

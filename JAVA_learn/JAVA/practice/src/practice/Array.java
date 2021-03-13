package practice;

public class Array {
	public static void main(String[] args) {
		int[] array;
		array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//		for(int i=0;i<array.length;i++) {
//			array[i] = i+1;
//		}
		System.out.println(add(array));
	}
	
	public static int add(int[] array) {
		int result = 0;
		for(int i : array) {
			result += i;
		}
		return result;
	}
}

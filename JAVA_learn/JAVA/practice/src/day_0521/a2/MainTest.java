package day_0521.a2;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MainTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("day_0521.a2.Car");
		
		System.out.println("클래스 정보");
		System.out.println("클래스 이름: " + clazz.getName());
		System.out.println();
		
		System.out.println("생성자 정보");
		Constructor[] csts = clazz.getDeclaredConstructors();
		System.out.println("생성자 이름: " + csts[0].getName());
		Class[] parameters = csts[0].getParameterTypes();
		System.out.println("첫번째 파라미터 타입: " + parameters[0].getName());
		System.out.println();
		
		System.out.println("필드 정보");
		Field[] fields = clazz.getDeclaredFields();
		for(Field field : fields) {
			System.out.println(field.getType().getSimpleName() + " " + field.getName());
			
			System.out.println();
		}
		
		System.out.println("메소드 정보");
		Method[] methods = clazz.getDeclaredMethods();
		for(Method method : methods) {
			System.out.println(method.getName());
		}
		
	}

}

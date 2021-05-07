package day_0507.a2_catch_order;

public class MainTest {
	public static void main(String[] args) {
		try {
			String[] s = {"일"};
			
			String data1 = s[0];
			String data2 = s[1];
			int value1 = Integer.parseInt(data1);
			int value2 = Integer.parseInt(data2);
			int result = value1 + value2;
			System.out.println(data1 + "+" + data2 + "=" + result);
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("실행 매개갑의 수가 부족합니다.");
		} catch(Exception e) {
			System.out.println("실행에 문제가 있습니다.");
		} finally {
			System.out.println("다시 실행하세요.");
		}
	}
}

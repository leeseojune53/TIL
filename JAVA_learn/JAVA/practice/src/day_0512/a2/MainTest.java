package day_0512.a2;

public class MainTest {
	
	public static void main(String[] args) {
		Account ac = new Account();
		
		ac.deposit(10000);
		System.out.println("예금액: " + ac.getBalance());
		
		try {
			ac.withdraw(30000);
		} catch (BalanceInsufficientException e) {
			String messgae = e.getMessage();
			System.out.println(messgae);
			System.out.println();
			e.printStackTrace();
		}
	}
	
}

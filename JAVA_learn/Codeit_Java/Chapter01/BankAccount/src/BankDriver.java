public class BankDriver {
    public static void main(String args[]){
        Person p1 = new Person();
        p1.name = "김신의";
        p1.age = 28;
        p1.cashAmount = 100000;


        // 은행 계좌 생성
        BankAccount a1 = new BankAccount();
        a1.balance = 500000;

        p1.account = a1;
        a1.owner = p1;

        a1.deposit(30000);
        a1.withdraw(170000);

    }
}

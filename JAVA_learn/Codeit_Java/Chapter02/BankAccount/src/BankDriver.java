public class BankDriver {
    public static void main(String[] args) {
        // 사람 1
        Person p1 = new Person("김신의", 12);
        p1.setCashAmount(30000);

        // 은행 계좌 1
        BankAccount a1 = new BankAccount(p1);
        a1.setBalance(100000);

        p1.setAccount(a1);
        a1.setOwner(p1);

        // 사람 2
        Person p2 = new Person("문종모", 25, 100000);

        // 은행 계좌 2
        BankAccount a2 = new BankAccount(500000, p2);

        p2.setAccount(a2);
        a2.setOwner(p2);

        // 계좌 이체 테스트
        a2.transfer(a1, 200000);
        a1.transfer(p2, 150000);
        p2.transfer(a1, 270000);
        p1.transfer(p2, 130000);
    }
}

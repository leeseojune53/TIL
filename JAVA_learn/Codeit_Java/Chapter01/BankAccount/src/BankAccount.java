public class BankAccount {
    int balance;
    Person owner;

    boolean deposit(int amount){
        if(owner.cashAmount>=amount){
            balance+=amount;
            owner.cashAmount-=amount;
            System.out.println(amount + "원 입금하였습니다. 잔고: " + balance + "원, 현금: " + owner.cashAmount + "원");
            return true;
        }else{
            System.out.println("입금 실패입니다. 잔고: " + balance + ", 현금: " + owner.cashAmount + "원");
            return false;
        }
    }

    boolean withdraw(int amount){
        if(balance>=amount){
            balance-=amount;
            owner.cashAmount+=amount;
            System.out.println(amount + "원 출금하였습니다. 잔고: " + balance + "원, 현금: " + owner.cashAmount + "원");
            return true;
        }else{
            System.out.println("출금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.cashAmount + "원");
            return false;
        }

    }

    boolean transfer(Person to, int amount){
        if(cashAmount>=amount){
            cashAmount-=amount;
            to.cashAmount+=amount;

            return true;
        }
        else{

            return false;
        }
    }
}

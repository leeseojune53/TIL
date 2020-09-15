public class BankAccount {
    private int balance;
    private Person owner;

    public BankAccount(int pBalance){
        if(pBalance < 0)
            balance = 0;
        else balance = pBalance;
    }

    public BankAccount(Person pOwner){
        owner = pOwner;
        balance = 0;
    }

    public BankAccount(int pBalance, Person pOwner){
        owner = pOwner;
        if(pBalance < 0)
            balance = 0;
        else balance = pBalance;
    }

    public void setBalance(int newbalance){
        balance = newbalance;
    }
    public int getbalance(){
        return balance;
    }

    public void setOwner(Person newowner){
        owner = newowner;
    }
    public Person getowner(){
        return owner;
    }

    boolean deposit(int amount){
        if(owner.getamount()>=amount){
            balance+=amount;
            owner.setCashAmount(owner.getamount()-amount);
            System.out.println(amount + "원 입금하였습니다. 잔고: " + balance + "원, 현금: " + owner.getamount() + "원");
            return true;
        }else{
            System.out.println("입금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getamount() + "원");
            return false;
        }
    }

    boolean withdraw(int amount){
        if(balance>=amount){
            balance-=amount;
            owner.setCashAmount(owner.getamount()+amount);
            System.out.println(amount + "원 출금하였습니다. 잔고: " + balance + "원, 현금: " + owner.getamount() + "원");
            return true;
        }else{
            System.out.println("출금 실패입니다. 잔고: " + balance + "원, 현금: " + owner.getamount() + "원");
            return false;
        }

    }

    // 첫 번째 파라미터: 받는 사람 (Person)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(Person to, int amount) {
        if(amount>=0 && balance-amount>=0){
            to.getbankaccount().setBalance(to.getbankaccount().getbalance()+amount);
            balance-=amount;
            System.out.println("true - from: " + owner.getname() + ", to: " + to.getname() + ", amount: " + amount + ", balance: " + balance);
            return true;
        }
        System.out.println("false - from: " + owner.getname() + ", to: " + to.getname() + ", amount: " + amount + ", balance: " + balance);
        return false;
    }

    // 첫 번째 파라미터: 받는 사람의 계정 (BankAccount)
    // 두 번째 파라미터: 이체할 금액 (정수)
    // 리턴 : 성공여부 (불린)
    public boolean transfer(BankAccount to, int amount) {
        if(amount>=0 && balance-amount>=0){
            to.setBalance(to.getbalance()+amount);
            balance-=amount;
            System.out.println("true - from: " + owner.getname() + ", to: " + to.getowner().getname() + ", amount: " + amount + ", balance: " + balance);
            return true;
        }
        System.out.println("false - from: " + owner.getname() + ", to: " + to.getowner().getname() + ", amount: " + amount + ", balance: " + balance);
        return false;
    }
}

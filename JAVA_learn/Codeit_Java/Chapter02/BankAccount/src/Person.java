public class Person {
    private String name;
    private int age;
    private int cashAmount;
    private BankAccount account;

    public void setName(String name){
        this.name = name;
    }
    public String getname(){
        return name;
    }

    public void setAge(int nage){
        age = nage;
    }
    public int getage(){
        return age;
    }

    public void setCashAmount(int amount){
        cashAmount = amount;
    }
    public int getamount(){
        return cashAmount;
    }

    public void setAccount(BankAccount account){
        this.account = account;
    }
    public BankAccount getbankaccount(){
        return account;
    }

    public boolean transfer(Person to, int amount) {
        if(amount>=0 && account.getbalance()-amount>=0){
            to.getbankaccount().setBalance(to.getbankaccount().getbalance()+amount);
            account.setBalance(account.getbalance()-amount);
            System.out.println("true - from: " + name + ", to: " + to.getname() + ", amount: " + amount + ", balance: " + account.getbalance());
            return true;
        }
        System.out.println("false - from: " + name + ", to: " + to.getname() + ", amount: " + amount + ", balance: " + account.getbalance());
        return false;
    }

    public boolean transfer(BankAccount to, int amount) {
        if(amount>=0 && account.getbalance()-amount>=0){
            to.setBalance(to.getbalance()+amount);
            account.setBalance(account.getbalance()-amount);
            System.out.println("true - from: " + name + ", to: " + to.getowner().getname() + ", amount: " + amount + ", balance: " + account.getbalance());
            return true;
        }
        System.out.println("false - from: " + name + ", to: " + to.getowner().getname() + ", amount: " + amount + ", balance: " + account.getbalance());
        return false;
    }

}

public class SavingsAccount extends Account {
    public SavingsAccount(String accountNo, String name, String address, String phoneNo, String dob, double balance) {
        super(accountNo, name, address, phoneNo, dob, balance);
    }

    public void withdraw(double amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            System.out.println("Amount withdrawn: " + amount);
            System.out.println("New balance: " + getBalance());
        } else {
            System.out.println("Insufficient Amount");
        }
    }

    
    public void deposit(double amount) {
        setBalance(getBalance() + amount);
        System.out.println("Amount deposited: " + amount);
        System.out.println("New Amount: " + getBalance());
    }

    
    public void fixedDeposit(double amount, int years) {
        setBalance(getBalance() + (amount * years * 0.05));
        System.out.println("Amount deposited in fixed deposit: " + amount);
        System.out.println("New balance: " + getBalance());
    }
}
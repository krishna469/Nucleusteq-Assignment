public class LoanAccount extends Account {
   
    public LoanAccount(String accountNo, String name, String address, String phoneNo, String dob, double balance) {
        super(accountNo, name, address, phoneNo, dob, balance);
    }

    
    public void payEMI(double amount) {
        setBalance(getBalance() - amount);
        System.out.println("EMI paid: " + amount);
        System.out.println("New balance: " + getBalance());
    }

    
    public void topUpLoan(double amount) {
      setBalance(getBalance() + amount);
      System.out.println("Loan topped up: " + amount);
      System.out.println("New balance: " + getBalance());
    }

    public void repayment(double amount) {
        setBalance(getBalance() - amount);
        System.out.println("Repayment Amount: " + amount);
        System.out.println("New balance: " + getBalance());
    }
}

/**
 * Class for creating a bank account model.
 */
public class BankAccountModel {

    // set the instance variables of the class
    private String accountHolder;
    private double balance;
    private long accountNumber;

    /**
     * Create a new instance of a bank account model.
     * @param accountHolder the account holder
     * @param balance the balance of the account
     * @param accountNumber the account number
     */
    public BankAccountModel(String accountHolder, double balance, long accountNumber) {

        this.accountHolder = accountHolder;
        this.balance = balance;
        this.accountNumber = accountNumber;

    }

    /**
     * Method for getting an account holder.
     * @return the account holder
     */
    public String getAccountHolder() {
        return accountHolder;

    }

    /**
     * Method for getting a balance.
     * @return the balance of an account
     */
    public double getBalance() {
        return balance;

    }

    /**
     * Method for getting an account number.
     * @return the account number
     */
    public long getAccountNumber() {

        return accountNumber;
    }


    /**
     * Method for depositing money into a bank account.
     * @param amount the amount of money to deposit
     */
    public void deposit(double amount) {

        balance += amount;
    }

    /**
     * Method for withdrawing money from a bank account.
     * @param amount the amount of money to withdraw
     */
    public void withdraw(double amount) {

        // check to see if we have sufficient funds to withdraw
        if (amount <= balance) {

            balance -= amount;

        } else {

            System.out.println("Insufficient balance");
        }

   }

}

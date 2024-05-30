/**
 * Class for creating a new instance of a bank account.
 */
public class BankAccount implements Account, Comparable<BankAccount> {

    // list all the interfaces types that this class implements

    // the instance variables for a bank account
    private double balance;
    private String accountHolder;
    private long accNumber;
    private static long routingNumber = 12345678;

    /**
     * Constructor for creating a new instance of a bank account.
     * @param name the name of the account holder
     * @param accNumber the account number
     */
    public BankAccount(String name, long accNumber) {

        this.balance = 0;
        this.accountHolder = name;
        this.accNumber = accNumber;

    }

    // the @override annotation is used in Java to indicate when we are overriding a method from a super class
    // or implementing an interface method

    /**
     * Method for depositing money into an account.
     * @param amount the amount to deposit
     */
    @Override
    public void deposit(double amount) {

        balance += amount;

    }

    /**
     * Method for withdrawing money from an account.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {

        balance -= amount;

    }

    /**
     * Method for getting the balance of an account.
     * @return the balance
     */
    @Override
    public double getBalance() {

        return this.balance;
    }

    /**
     * Method for getting the account number for an account.
     * @return the account number
     */
    @Override
    public long getAccountNumber() {

        return this.accNumber;
    }

    // the interface does not stop us from adding other methods like the transfer method!
    // the interface just binds us to implement the methods enumerated in the interface

    /**
     * Method for transferring money from one account to another.
     * @param other the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(BankAccount other, double amount) {

        this.withdraw(amount);
        other.deposit(amount);

    }

    /**
     * Method for comparing two bank accounts.
     * @param otherObject the object to be compared.
     * @return -1 if a is smaller, 0 if equal, 1 if b is smaller
     */
    @Override
    public int compareTo(BankAccount otherObject) {

        // our object is less than the specified object
        if (this.balance < otherObject.getBalance()) {
            return -1; // return a negative number
        }
        // our object is greater than the specified object
        if (this.balance > otherObject.getBalance()) {
            return 1; // return a positive number
        }
        // our two objects are the same
        return 0;
    }

    /**
     * Method for returning a string representation of a bank account.
     * @return the string representation of a bank account
     */
    @Override
    public String toString() {
        return accountHolder + " (" + accNumber + "), bal: " + balance;
    }

}

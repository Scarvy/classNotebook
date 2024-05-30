/**
 * Create an interface for an account.
 */
public interface Account {

    // any bank account class that adheres to this account interface must implement these methods
    // (interfaces represent a "contract" that implementing classes must adhere to)

    // interfaces only specify abstract methods for all the subclasses to include, not the constructor!
    // (these methods are abstract b/c there is not currently an implementation for them)

    // Note: no implementation of the methods is provided

    // we can specify constants in our interfaces
    // constants in interfaces are implicitly public static final, so they can be accessed from any class
    // that implements the interface
    double MAXIMUM_DAILY_WITHDRAWAL_LIMIT = 1000.00;

    /**
     * Method for depositing money into a bank account.
     * @param amount the amount to deposit
     */
    void deposit(double amount);

    /**
     * Method for withdrawing money from a bank account.
     * @param amount the amount to withdraw
     */
    void withdraw(double amount);

    /**
     * Method for checking the balance of an account.
     * @return the balance of the account
     */
    double getBalance();

    /**
     * Method for getting an account number.
     * @return the account number
     */
    long getAccountNumber();

}
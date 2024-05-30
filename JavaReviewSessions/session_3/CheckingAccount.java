/**
 * Class for creating a new instance of a checking account.
 */
public class CheckingAccount extends BankAccount {

    // instance variables
    private double fee;

    /**
     * Constructor for creating a new checking account.
     * @param name the name of the account holder
     * @param accNumber the account number
     * @param fee the fee
     */
    public CheckingAccount(String name, long accNumber, double fee) {

        // by default, we invoke the super.
        // super is a keyword that refers to the parent class of the current class
        super(name, accNumber);
        this.fee = fee;

    }

    /**
     * Method for withdrawing money from a checking account.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {

        // override the bank account withdraw method

        super.withdraw(amount);
        super.withdraw(fee);

    }

    // why don't we need to explicitly write out a deposit method here?
    // - because the bank account already provides a deposit method for us
    // the only reason that we wrote a different withdrawal method here is because we wanted to add additional
    // functionality

}

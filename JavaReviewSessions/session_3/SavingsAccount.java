public class SavingsAccount extends BankAccount{

    // instance variables
    private double interestRate;

    /**
     * Constructor for creating a new instance of a savings account.
     * @param name the name of the account holder
     * @param accNumber the account number
     * @param interestRate the interest rate
     */
    public SavingsAccount(String name, long accNumber, double interestRate) {

        // we have a different constructor than the superclass because we have some subclass specific fields

        // initialize the instance variables of the super class
        super(name, accNumber);

        // initialize the instance variable of the current class
        this.interestRate = interestRate;

    }

    /**
     * Method for accumulating interest in a savings account.
     */
    public void accumulateInterest() {

        super.deposit(super.getBalance() * interestRate);

        // we use super.deposit() here because we are specifying that we are calling this method from
        // the super class, but we could also have used this.deposit() or just deposit()

    }

    /**
     * Override the withdrawal method to add limits on amounts a user can withdraw.
     * @param amount the amount to withdraw
     */
    @Override
    public void withdraw(double amount) {
        if (amount > MAXIMUM_DAILY_WITHDRAWAL_LIMIT) {
            System.out.println("Cannot withdraw more than daily allowed limit.");
        } else {
            super.withdraw(amount);
        }
    }

}

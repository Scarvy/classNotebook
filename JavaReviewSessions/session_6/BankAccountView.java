public class BankAccountView {

    /**
     * Method for printing out the key information of a bank account.
     * @param accountHolder the account holder
     * @param balance the account balance
     * @param accountNumber the account number
     */
    public void printBankAccountDetails(String accountHolder, double balance, long accountNumber) {

        System.out.println("Bank Account Details:");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: $" + balance);

    }
}

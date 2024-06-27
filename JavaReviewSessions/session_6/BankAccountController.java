/**
 * Class for controlling a bank account model and view.
 */
public class BankAccountController {

    // create out instance variables where a controller holds both a model and a view
    private BankAccountModel model;
    private BankAccountView view;

    /**
     * Constructor for creating a new instance of a controller.
     * @param model the model
     * @param view the view
     */
    public BankAccountController(BankAccountModel model, BankAccountView view) {
        this.model = model;
        this.view = view;
    }

    /**
     * Method for depositing an amount into a bank account model.
     * @param amount the amount to deposit into a bank account
     */
    public void deposit(double amount) {

        model.deposit(amount);
    }

    /**
     * Method for withdrawing an amount from a bank account model.
     * @param amount the amount to withdraw
     */
    public void withdraw(double amount) {

        model.withdraw(amount);
    }

    /**
     * Method for updating a view.
     */
    public void updateView() {

        view.printBankAccountDetails(model.getAccountHolder(), model.getBalance(), model.getAccountNumber());
    }

}

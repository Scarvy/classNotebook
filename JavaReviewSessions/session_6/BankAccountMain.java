public class BankAccountMain {

    public static void main(String[] args) {

        // create the model
        BankAccountModel model = new BankAccountModel("James", 1000, 12345);

        // create the view
        BankAccountView view = new BankAccountView();

        // create the controller
        BankAccountController controller = new BankAccountController(model, view);

        // update the view to show the current state
        //controller.updateView();

        controller.deposit(500);

        controller.withdraw(200);

        controller.updateView();

    }
}

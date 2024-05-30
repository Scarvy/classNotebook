import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {


        SavingsAccount s = new SavingsAccount("Ethan", 1234, .05);
        CheckingAccount c = new CheckingAccount("James", 2345, 5);
        SavingsAccount s2 = new SavingsAccount("John", 5678, .05);

        System.out.println(s);

        ArrayList<BankAccount> bankAccounts = new ArrayList<>();
        bankAccounts.add(s);
        bankAccounts.add(c);
        bankAccounts.add(s2);

        Stack<BankAccount> bankAccountStack = new Stack<>();

        s.deposit(200);
        c.deposit(500);
        s2.deposit(50);

        Collections.sort(bankAccounts);

        //bankAccounts.sort(null);

        System.out.println(bankAccounts);

        
    }

}
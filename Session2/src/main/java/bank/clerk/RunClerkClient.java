package bank.clerk;

import bank.administrator.AdministratorClient;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RunClerkClient {

    public static void main(String[] args) {

        // add user input
        Scanner scanner = new Scanner(System.in);


        ClerkClient rml = null;
        try {
            rml = new ClerkClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        while(true) {
            System.out.println("Withdraw (1) or Deposit(2)?");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    int acc = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter amount as integer:" );
                    double amount = scanner.nextInt();
                    scanner.nextLine();
                    rml.withdraw(acc, amount);

                    System.out.println(amount + " has been withdrawed from " + acc);
                    break;
                case 2:
                    System.out.print("Enter account number: ");
                    int dacc = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter amount as integer:" );
                    double damount = scanner.nextInt();
                    scanner.nextLine();

                    rml.deposit(dacc, damount);

                    System.out.println(damount + " has been deposited into " + dacc);
                    break;

                default:
                    System.out.println("Only 1 or 2 is acceptable input!");
            }
        }

    }
}

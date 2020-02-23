package Session2.bank.administrator;

import Session2.bank.customer.CustomerClient;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RunAdministratorClient {

    public static void main(String[] args) throws RemoteException {
        // add user input
        Scanner scanner = new Scanner(System.in);

        // setup the client
        AdministratorClient rml = null;
        try {
            rml = new AdministratorClient();
        } catch (RemoteException e) {
            e.printStackTrace();
        }



        while (true) {
            System.out.println("press 'Enter' to create new account.");
            scanner.nextLine();

            System.out.print("Enter account number: ");
            int accountNo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Enter new pin: ");
            int pin = scanner.nextInt();
            scanner.nextLine();
            System.out.print("If startbalance:");
            int startBalance = scanner.nextInt();
            scanner.nextLine();
            try {
                rml.createAccount(accountNo, pin, startBalance);
                System.out.println("Account created");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }







    }
}

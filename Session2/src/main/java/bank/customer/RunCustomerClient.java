package Session2.bank.customer;

import java.rmi.RemoteException;
import java.util.Scanner;

public class RunCustomerClient {

    public static void main(String[] args) throws RemoteException {

        // add user input
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: " );
        int acc = Integer.parseInt(scanner.next());
        scanner.nextLine();
        System.out.print("Enter pin number: " );
        int pin = Integer.parseInt(scanner.next());
        scanner.nextLine();

        CustomerClient rml = null;
        try {
            rml = new CustomerClient(acc, pin);
        } catch (RemoteException e) {
            e.printStackTrace();
        }


        while(true) {
            System.out.println("Your current balance: " + rml.getBalance());
            System.out.print("Enter withdraw amount: ");
            rml.withdraw(Double.parseDouble(String.valueOf(scanner.nextInt())));
            scanner.nextLine();
        }



    }
}

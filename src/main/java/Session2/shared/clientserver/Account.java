package Session2.shared.clientserver;

import java.io.Serializable;

public class Account implements Serializable {

    private int accountNumber;
    private int pin;
    private double balance;

    public Account(int accountNumber, int pin) {
        this.accountNumber = accountNumber;
        this.balance = 0;
        this.pin = pin;
    }

    public Account(int accountNo, int pin, double startBalance) {
        this.accountNumber = accountNo;
        this.balance = startBalance;
        this.pin = pin;
    }

    public boolean correctPin(int pin) {
        return this.pin == pin;
    }

    public int getAccountNumber() {return accountNumber;}

    public double getBalance() {
        return balance;
    }


    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
        System.out.println("new Balance: " + balance);
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }
}

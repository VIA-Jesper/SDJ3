package Session2.shared.database;

import java.io.Serializable;

public class Record implements Serializable {

    private int account;
    private double balance;
    public Record(int account, double balance) {
        this.account = account;
        this.balance = balance;
    }

    public int getAccount() {
        return this.account;
    }

    public double getBalance() {
        return this.balance;
    }


    @Override
    public String toString() {
        return "Records{" +
                "account=" + account +
                ", balance=" + balance +
                '}';
    }
}

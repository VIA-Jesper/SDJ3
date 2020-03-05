package database.database;

import Session2.shared.database.Record;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteJDBC {

    public SQLiteJDBC() {
        createTables();
    }

    private Connection getConn() throws SQLException, ClassNotFoundException {
        Class.forName("org.sqlite.JDBC");
        return DriverManager.getConnection("jdbc:sqlite:./src/main/java/Session2/database/bank.db");
    }

    private Statement stmt = null;

    public void createTables() {
        Connection connection = null;
        try {
            connection = getConn();
            System.out.println("Opened database successfully");

            stmt = connection.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS Bank " +
                    "(AccountNumber INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "Balance DOUBLE); ";
            stmt.executeUpdate(sql);
            stmt.close();
            connection.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Table created successfully");
    }

    public double getBalance(int accountNumber) throws Exception {
        Connection c = null;
        Statement stmt = null;
        try {
            c = getConn();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Bank WHERE AccountNumber=" + accountNumber + ";" );


            while ( rs.next() ) {
                int id = rs.getInt("AccountNumber");
                double balance = rs.getDouble("Balance");


                System.out.println( "AccountNumber = " + id );
                System.out.println( "Balance = " + balance );
                System.out.println();
                c.close();
                return balance;
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            c.close();
        }
        throw new Exception("Account not found");
    }
    public List<Record> getRecords() {
        Connection c = null;
        Statement stmt = null;
        List<Record> records = new ArrayList<Record>();
        try {
            c = getConn();
            c.setAutoCommit(false);
            System.out.println("Opened database successfully");

            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "SELECT * FROM Bank;" );

            while ( rs.next() ) {
                int id = rs.getInt("AccountNumber");
                double balance = rs.getDouble("Balance");

                records.add(new Record(id, balance));

                System.out.println( "AccountNumber = " + id );
                System.out.println( "Balance = " + balance );
                System.out.println();
            }
            rs.close();
            stmt.close();
            c.close();
        } catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            try {
                c.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return records;
    }

    public int createCustomer(double startAmount) throws Exception {
        Connection c = null;
        Statement stmt = null;

        try {

            c = getConn();
            c.setAutoCommit(true);


            stmt = c.createStatement();
            String sql = String
                .format("INSERT INTO Bank (Balance) VALUES (%s);", startAmount);
            stmt.execute(sql);
            c.close();
            System.out.println("Customer successfully created...");
            return getRecords().size() + 1;


        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        c.close();
        throw new Exception("Could not create customer!");
    }

    // has to be update
    public void deposit(int account, double amount) {

        Connection connection = null;
        try {
            connection = getConn();
            connection.setAutoCommit(true);

            stmt = connection.createStatement();

            double oldValue = getBalance(account);
            double newValue = oldValue + amount;

            String sql = "UPDATE Bank SET Balance = " + newValue + " WHERE AccountNumber=" + account + ";";
            stmt.executeUpdate(sql);


            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        System.out.println("Records created successfully");
    }


    public void withdraw(int account, double amount) {
        Connection connection = null;
        try {
            connection = getConn();
            connection.setAutoCommit(true);

            stmt = connection.createStatement();

            double oldValue = getBalance(account);
            double newValue = oldValue - amount;

            String sql = "UPDATE Bank SET Balance = " + newValue + " WHERE AccountNumber=" + account + ";";
            stmt.executeUpdate(sql);


            stmt.close();
            connection.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            try {
                connection.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        System.out.println("Records created successfully");
    }


}

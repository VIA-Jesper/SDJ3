package rmiexchangerate.server;

import rmiexchangerate.shared.Subject;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class RunServer {

    public static void main(String[] args) {
        try {
            RmiServer rmiServer = new RmiServer();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("exchange", rmiServer);
            System.out.println("Server started...");


            // Update exchange rate periodic
            new Thread(() -> {
                while (true) {
                    double newExchangeRate = rmiServer.getExchangeRate();
                    System.out.println("New Exchange rate from: " + rmiServer.getExchangeRate() + " to: " + newExchangeRate);
                    rmiServer.updateExchangeRate(symTrapezoidRandom(0.0001, 3, rmiServer.getExchangeRate()));
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();


        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }


    }

    /**
     * Return a pseudorandom double for the symmetric trapezoidal distribution
     * defined by the triple {@code (min, max, x)}
     */
    public static double symTrapezoidRandom(double min, double max, double x) {
        final double a1 = 0.5 * min;
        final double a2 = a1;

        final double b1 = max - a2 - x;
        final double b2 = a2 + x;

//        if ((a1 + b2) >= (a2 + b1)) {
//            throw new IllegalArgumentException();
//        }
        Random rnd = new Random();
        double u = a1 + (b1 - a1) * rnd.nextDouble();
        double v = a2 + (b2 - a2) * rnd.nextDouble();

        return u + v;
    }
}

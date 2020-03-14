package publishsubscriberbroker;

public class Main {

    public static void main(String[] args) {

        // create the publisher. We only want one instance.
        EventPublisher ep = new EventPublisher();
        // create subscriber
        Subscriber s = new Subscriber("Subscriber 1");
        Subscriber s2 = new Subscriber("Subscriber 2");
        Subscriber s3 = new Subscriber("Subscriber 3");

        // create event
        Event e = new Event("Normal", "This is just a string test");
        Event e2 = new Event("High", "High message test");
        // attach
        ep.attach("Normal", s);
        ep.attach("High", s);
        ep.attach("Normal", s2);
        // force update
        System.out.println("------  Adding event to queue -------");
        ep.notifyUpdateType("Normal", e);

        System.out.println("------  Request all stored data -------");
        ep.broadcast();

        System.out.println("----- Request Normal data to subscribers -----");
        ep.broadcast("Normal");

        System.out.println("----- Request High data to subscribers -----");
        ep.broadcast("High");

        System.out.println("----- adding new event with high priority -------");
        ep.addPayLoad("High", e2);
        System.out.println("----- Request High data to subscribers -----");
        ep.broadcast("High");
        System.out.println("----- Checks normal ------");
        ep.broadcast("Normal");


    }
}

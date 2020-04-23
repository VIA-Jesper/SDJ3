package publishersubscriber.test;

import publishersubscriber.models.Message;
import publishersubscriber.models.PubSubObject;
import publishersubscriber.pubsub.PubSubService;
import publishersubscriber.pubsub.publisher.Publisher;
import publishersubscriber.pubsub.publisher.PublisherImpl;
import publishersubscriber.pubsub.subscriber.Subscriber;
import publishersubscriber.pubsub.subscriber.SubscriberImpl;

import java.util.Date;


public class Run {

    public static void main(String[] args) {

        Publisher normalPriorityPublisher = new PublisherImpl();
        Publisher highPriorityPublisher = new PublisherImpl();


        Subscriber normalSub = new SubscriberImpl();
        Subscriber highSub = new SubscriberImpl();
        Subscriber allSub = new SubscriberImpl();

        PubSubService pubsubService = new PubSubService();

        // Create one message that will be send to all subscribers of 'NORMAL_MSG_OBJ' type.
        Message msg = new Message("NORMAL: This is the first message", new Date(), "Bob");
        PubSubObject psObj1 = new PubSubObject("NORMAL", msg);

        // Create one message that will be send to all subscribers of 'PRIORITY_MSG_OBJ' type.
        Message msg2 = new Message("HIGH: Second msg", new Date(), "Alice");
        PubSubObject psObj2 = new PubSubObject("HIGH", msg2);


        normalPriorityPublisher.publish(psObj1, pubsubService);
        highPriorityPublisher.publish(psObj2, pubsubService);

        //    Subscribe
        normalSub.addSubscriber("NORMAL", pubsubService);

        highSub.addSubscriber("HIGH", pubsubService);

        allSub.addSubscriber("NORMAL", pubsubService);
        allSub.addSubscriber("HIGH", pubsubService);


        // Broadcast that a new message has been added
        pubsubService.broadcast();

        // see objs stored
        System.out.println("Normal objects: ");
        normalSub.printMessages();

        System.out.println("High objects: ");
        highSub.printMessages();

        System.out.println("All objects: ");
        allSub.printMessages();








    }
}

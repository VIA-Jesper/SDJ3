package exercise5_1__pubsub.test;

import exercise5_1__pubsub.models.ElementType;
import exercise5_1__pubsub.models.Message;
import exercise5_1__pubsub.models.PubSubObject;
import exercise5_1__pubsub.pubsub.PubSubService;
import exercise5_1__pubsub.pubsub.publisher.Publisher;
import exercise5_1__pubsub.pubsub.publisher.PublisherImpl;
import exercise5_1__pubsub.pubsub.subscriber.Subscriber;
import exercise5_1__pubsub.pubsub.subscriber.SubscriberImpl;

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
        PubSubObject psObj1 = new PubSubObject(ElementType.NORMAL_MSG_OBJ, msg);

        // Create one message that will be send to all subscribers of 'PRIORITY_MSG_OBJ' type.
        Message msg2 = new Message("HIGH: Second msg", new Date(), "Alice");
        PubSubObject psObj2 = new PubSubObject(ElementType.PRIORITY_MSG_OBJ, msg2);


        normalPriorityPublisher.publish(psObj1, pubsubService);
        highPriorityPublisher.publish(psObj2, pubsubService);

        //    Subscribe
        normalSub.addSubscriber(ElementType.NORMAL_MSG_OBJ, pubsubService);

        highSub.addSubscriber(ElementType.PRIORITY_MSG_OBJ, pubsubService);

        allSub.addSubscriber(ElementType.PRIORITY_MSG_OBJ, pubsubService);
        allSub.addSubscriber(ElementType.NORMAL_MSG_OBJ, pubsubService);


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

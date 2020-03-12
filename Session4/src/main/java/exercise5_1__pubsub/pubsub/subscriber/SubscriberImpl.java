package exercise5_1__pubsub.pubsub.subscriber;


import exercise5_1__pubsub.models.ElementType;
import exercise5_1__pubsub.pubsub.PubSubService;

public class SubscriberImpl extends Subscriber{

    //Add subscriber with PubSubService for a topic
    public void addSubscriber(ElementType type, PubSubService pubSubService){
        pubSubService.addSubscriber(type, this);
    }

    //Unsubscribe subscriber with PubSubService for a topic
    public void unSubscribe(ElementType type, PubSubService pubSubService){
        pubSubService.removeSubscriber(type, this);
    }

    //Request specifically for messages related to topic from PubSubService
    public void getMessagesForSubscriberOfTopic(ElementType type, PubSubService pubSubService) {
        pubSubService.getMessagesForSubscriberOfTopic(type, this);

    }
}
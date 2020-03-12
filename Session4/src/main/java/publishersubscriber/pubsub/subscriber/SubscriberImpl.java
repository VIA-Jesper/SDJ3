package publishersubscriber.pubsub.subscriber;


import publishersubscriber.pubsub.PubSubService;

public class SubscriberImpl extends Subscriber{

    //Add subscriber with PubSubService for a topic
    public void addSubscriber(String type, PubSubService pubSubService){
        pubSubService.addSubscriber(type, this);
    }

    //Unsubscribe subscriber with PubSubService for a topic
    public void unSubscribe(String type, PubSubService pubSubService){
        pubSubService.removeSubscriber(type, this);
    }

    //Request specifically for messages related to topic from PubSubService
    public void getMessagesForSubscriberOfTopic(String type, PubSubService pubSubService) {
        pubSubService.getMessagesForSubscriberOfTopic(type, this);

    }
}
package publishersubscriber.pubsub.subscriber;


import publishersubscriber.models.PubSubObject;
import publishersubscriber.pubsub.PubSubService;

import java.util.ArrayList;
import java.util.List;

public abstract class Subscriber {

    //store all messages received by the subscriber
    private List<PubSubObject> subscriberMessages = new ArrayList<PubSubObject>();

    public List<PubSubObject> getSubscriberObjects() {
        return subscriberMessages;
    }


    public void setSubscriberObjects(List<PubSubObject> subscriberMessages) {
        this.subscriberMessages = subscriberMessages;
    }

    //Add subscriber with PubSubService for a topic
    public abstract void addSubscriber(String type, PubSubService pubSubService);

    //Unsubscribe subscriber with PubSubService for a topic
    public abstract void unSubscribe(String type, PubSubService pubSubService);

    //Request specifically for messages related to topic from PubSubService
    public abstract void getMessagesForSubscriberOfTopic(String type, PubSubService pubSubService);

    //Print all messages received by the subscriber
    public void printMessages(){
        for(PubSubObject obj : subscriberMessages){
            System.out.println("Type -> "+ obj.getType() + " : " + obj.getPayload());
        }
    }
}
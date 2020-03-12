package exercise5_1__pubsub.pubsub;

import exercise5_1__pubsub.models.ElementType;
import exercise5_1__pubsub.models.PubSubObject;
import exercise5_1__pubsub.pubsub.subscriber.Subscriber;

import java.util.*;

public class PubSubService {
    //Keeps set of subscriber type wise, using 'set' to prevent duplicates
    Map<ElementType, Set<Subscriber>> subscribersTypeMap = new HashMap<>();

    //Holds objects published by publishers
    Queue<PubSubObject> objQueue = new LinkedList<>();

    //Adds obj sent by publisher to queue
    public void addObjectToQueue(PubSubObject psObj){
        objQueue.add(psObj);
    }

    //Add a new Subscriber for a type
    public void addSubscriber(ElementType type, Subscriber subscriber){

        if (subscribersTypeMap.containsKey(type)){
            System.out.println("Subscriber exists in the subscriber map, adding...");
            Set<Subscriber> subscribers = subscribersTypeMap.get(type);
            subscribers.add(subscriber);
            subscribersTypeMap.put(type, subscribers);
        }else{
            System.out.println("Subscriber does not exist in subscriber type map. Creating and adding...");
            Set<Subscriber> subscribers = new HashSet<Subscriber>();
            subscribers.add(subscriber);
            subscribersTypeMap.put(type, subscribers);
        }
    }

    //Remove an existing subscriber for a topic
    public void removeSubscriber(ElementType type, Subscriber subscriber){
        System.out.println("Removing subscriber");
        if(subscribersTypeMap.containsKey(type)){
            Set<Subscriber> subscribers = subscribersTypeMap.get(type);
            subscribers.remove(subscriber);
            subscribersTypeMap.put(type, subscribers);
        }
    }

    //Broadcast new messages added in queue to All subscribers of the topic. messagesQueue will be empty after broadcasting
    public void broadcast(){
        if(objQueue.isEmpty()){
            System.out.println("No messages from publishers to display");
        }else{
            while(!objQueue.isEmpty()){
                PubSubObject psObj = objQueue.remove();
                ElementType type = psObj.getType();

                Set<Subscriber> subscribersOfType = subscribersTypeMap.get(type);

                // check for nullpointer - skip if needed
                if (subscribersOfType == null) {
                    continue;
                }
                // loop through and find subscribers for each type
                for(Subscriber subscriber : subscribersOfType) {
                    //add broadcasted message to subscribers obj queue
                    List<PubSubObject> subscriberObjects = subscriber.getSubscriberObjects();
                    subscriberObjects.add(psObj);
                    // add list of objects (just all of them) to the subscribers list which then can be printed.
                    subscriber.setSubscriberObjects(subscriberObjects);

                }
            }
        }
    }

    //Sends messages about a type for subscriber at any point
    public void getMessagesForSubscriberOfTopic(ElementType type, Subscriber subscriber) {
        if(objQueue.isEmpty()){
            System.out.println("No messages from publishers to display");
        }else{
            while(!objQueue.isEmpty()){
                PubSubObject obj = objQueue.remove();

                if(obj.getType() == type){

                    Set<Subscriber> subscribersOfTopic = subscribersTypeMap.get(type);

                    for(Subscriber _subscriber : subscribersOfTopic){
                        if(_subscriber.equals(subscriber)){
                            //add broadcasted message to subscriber message queue
                            List<PubSubObject> subscriberMessages = subscriber.getSubscriberObjects();
                            subscriberMessages.add(obj);
                            subscriber.setSubscriberObjects(subscriberMessages);
                        }
                    }
                }
            }
        }
    }

}

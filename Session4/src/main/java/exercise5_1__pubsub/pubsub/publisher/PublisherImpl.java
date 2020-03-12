package exercise5_1__pubsub.pubsub.publisher;

import exercise5_1__pubsub.models.PubSubObject;
import exercise5_1__pubsub.pubsub.PubSubService;


public class PublisherImpl implements Publisher {
    //Publishes new message to PubSubService
    @Override
    public void publish(PubSubObject pbObj, PubSubService pubSubService) {
        System.out.println("publish object");
        pubSubService.addObjectToQueue(pbObj);
    }
}
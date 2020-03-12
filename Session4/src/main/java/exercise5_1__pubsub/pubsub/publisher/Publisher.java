package exercise5_1__pubsub.pubsub.publisher;

import exercise5_1__pubsub.models.PubSubObject;
import exercise5_1__pubsub.pubsub.PubSubService;

public interface Publisher {

    //Publishes new message to PubSubService
    void publish(PubSubObject pbObj, PubSubService pubSubService);
}
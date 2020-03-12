package publishersubscriber.pubsub.publisher;

import publishersubscriber.models.PubSubObject;
import publishersubscriber.pubsub.PubSubService;

public interface Publisher {

    //Publishes new message to PubSubService
    void publish(PubSubObject pbObj, PubSubService pubSubService);
}
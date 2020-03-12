package publishersubscriber.pubsub.publisher;

import publishersubscriber.models.PubSubObject;
import publishersubscriber.pubsub.PubSubService;


public class PublisherImpl implements Publisher {
    //Publishes new message to PubSubService
    @Override
    public void publish(PubSubObject pbObj, PubSubService pubSubService) {
        pubSubService.addObjectToQueue(pbObj);
    }
}
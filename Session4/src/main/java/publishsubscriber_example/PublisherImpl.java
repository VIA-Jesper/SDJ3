package publishsubscriber_example;

public class PublisherImpl implements Publisher {
    //Publishes new message to publishsubscriber_example.PubSubService
    public void publish(Message message, PubSubService pubSubService) {
        pubSubService.addMessageToQueue(message);
    }
}
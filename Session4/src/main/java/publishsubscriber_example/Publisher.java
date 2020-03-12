package publishsubscriber_example;

public interface Publisher {

    //Publishes new message to publishsubscriber_example.PubSubService
    void publish(Message message, PubSubService pubSubService);
}
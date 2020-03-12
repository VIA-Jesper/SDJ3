package Session4.publishsubscriber_example;


public interface Publisher {

    //Publishes new message to PubSubService
    void publish(Message message, PubSubService pubSubService);
}
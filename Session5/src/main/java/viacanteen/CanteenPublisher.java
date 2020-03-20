package main.java.viacanteen;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

public class CanteenPublisher {

    private final static String QUEUE_NAME = "via_canteen_products_queue";

    public static void main(String[] args) throws Exception {

        String[] viaProducts = {"Spinach Smoothie", "SoTasty Hawai Pizza"};
        // factory pattern to init connection
        ConnectionFactory factory = new ConnectionFactory();
        // set the host name.
        factory.setHost("localhost");
        // create the connection using the factory instance
        // and initialize the channel using connection
        // channel is responsible for sending, receiving, plus some queue operations
        try (Connection conn = factory.newConnection(); Channel channel = conn.createChannel()) {
            // with channel, we can declare, bind, unbind, del queue, ...
            // declare the queue
            // queue name, passive?, exclusive?, autoDel? any arguments
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);
            // publish message directly to the provided queue
            for (String vp : viaProducts) {
                String message = "VIA Canteen's new product: " + vp;
                //  exchange, routingKey, AMQP.properties, byte[] body of msg

                channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
                System.out.println(" [x] Sent '" + message + "'");
            }

        }

    }
}

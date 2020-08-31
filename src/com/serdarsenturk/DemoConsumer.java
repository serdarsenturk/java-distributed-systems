package com.serdarsenturk;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class DemoConsumer {

    public static final String EX = "demo-exchange";
    public static final String Q1 = "demo-queue-1";
//    public static final String Q2 = "demo-queue-2";
//    public static final String Q3 = "demo-queue-3";
    public static final String K1 = "key1";
//    public static final String K2 = "key2";
//    public static final String K3 = "key3";

    public static void demoConsumer() throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqps://ymmlbeft:IPSFfJDg35dEtLtQttfQNKnIw0XCRokl@sparrow.rmq.cloudamqp.com/ymmlbeft");

        Connection connection = factory.newConnection();

        Channel channel1 = connection.createChannel();
//        Channel channel2 = connection.createChannel();
//        Channel channel3 = connection.createChannel();

        channel1.exchangeDeclare(EX, BuiltinExchangeType.DIRECT);
        channel1.queueDeclare(Q1, false, false, false, null);
//        channel2.queueDeclare(Q2, false, false, false, null);
//        channel3.queueDeclare(Q3, false , false , false, null);
        channel1.queueBind(Q1, EX, K1);
//        channel2.queueBind(Q2, EX, K2);
//        channel3.queueBind(Q3, EX, K3);

        Consumer consumer1 = new DefaultConsumer(channel1) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties, byte[] body) {
                System.out.println("Consumer1 " + envelope.getRoutingKey() + " Comment received: " + new String(body));
            }
        };
//
//        Consumer consumer2 = new DefaultConsumer(channel2) {
//            @Override
//            public void handleDelivery(String consumerTag, Envelope envelope,
//                                       AMQP.BasicProperties properties, byte[] body) {
//                System.out.println("Consumer2 " + envelope.getRoutingKey() + " Mail received: " + new String(body));
//            }
//        };
//
//        Consumer consumer3 = new DefaultConsumer(channel3){
//            @Override
//            public void handleDelivery(String consumeTag, Envelope envelope,
//                                       AMQP.BasicProperties properties, byte[] body){
//                System.out.println("Consumer" + envelope.getRoutingKey() + "Mails fetched:" + new String(body));
//            }
//        };

        channel1.basicConsume(Q1, true, consumer1);
//        channel2.basicConsume(Q2, true, consumer2);
//        channel3.basicConsume(Q3, true, consumer3);
    }

}

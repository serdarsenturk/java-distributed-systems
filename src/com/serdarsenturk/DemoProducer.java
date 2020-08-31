package com.serdarsenturk;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class DemoProducer {
    public static final String EX = "demo-exchange";
    public static final String K1 = "key1";
//    public static final String K2 = "key2";
//    public static final String K3 = "key3";


    public static void MovieProducer(String comment) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("amqps://ymmlbeft:IPSFfJDg35dEtLtQttfQNKnIw0XCRokl@sparrow.rmq.cloudamqp.com/ymmlbeft");

        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EX, BuiltinExchangeType.DIRECT);

        channel.basicPublish(EX, K1, null, comment.getBytes());
        System.out.println(K1 + " Comment sent: " + comment);

//        String mailNotfy = "MailSent";
//        channel.basicPublish(EX, K2, null, mailNotfy.getBytes());
//        System.out.println(K2 + mailNotfy);
//
//        String auditLog = "MailTo:Producer, MailFrom:Consumer2, title:Comment Status, Comment:" + comment;
//        channel.basicPublish(EX, K3, null, auditLog.getBytes());
//        System.out.println(K3 +  auditLog);

//        for (int i=0; i < 10; i++){
//            String message = "Hello world" + i;
//            if (i%2 == 0){
//                channel.basicPublish(EX, K1, null, message.getBytes());
//                System.out.println(K1 + "Message Sent: " + message);
//            }else {
//                channel.basicPublish(EX, K2, null, message.getBytes());
//                System.out.println(K2 + "Message Sent :" + message);
//            }
//            Thread.sleep(1000);
//        }
        channel.close();
        connection.close();
    }
}

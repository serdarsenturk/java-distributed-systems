package com.serdarsenturk;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class DemoProducer {
    public static final String EX = "demo1";
    public static final String message = "message";
    public static final String mail_queue = "mail";

    public static void MovieProducer(String comment) throws NoSuchAlgorithmException, KeyManagementException, URISyntaxException, IOException, TimeoutException, InterruptedException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setUri("a");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()){

            channel.queueDeclare(message, true, false, false, null);
            channel.queueDeclare(mail_queue, true, false, false, null);

            channel.basicPublish("", message,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    comment.getBytes("UTF-8"));

            channel.basicPublish("", mail_queue,
                    MessageProperties.PERSISTENT_TEXT_PLAIN,
                    comment.getBytes("UTF-8"));

            System.out.println(" [x] Sent Your Comment : '" + comment + "'");

//            channel.exchangeDeclare(EX, BuiltinExchangeType.DIRECT);
//
//            channel.basicPublish(EX, "one", null, comment.getBytes("UTF-8"));
//            channel.basicPublish(EX, "two", null, comment.getBytes("UTF-8"));

//            channel.basicPublish(EX, "", null, Mail.getBytes("UTF-8"));
//            channel.basicPublish(EX, "", null, AuditLog.getBytes("UTF-8"));


//        for (int i=0; i < 10; i++){
//            String message = "Hello world" + i;
//            if (i%2 == 0){
//                channel.basicPublish(EX, K1, null, message.getBytes());
//                System.out.println(K1 + "Message Sent: " + me ssage);
//            }else {
//                channel.basicPublish(EX, K2, null, message.getBytes());
//                System.out.println(K2 + "Message Sent :" + message);
//            }
//            Thread.sleep(1000);
//        }
        }
    }
}

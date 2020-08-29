package com.serdarsenturk;

import com.rabbitmq.client.BasicProperties;
import com.rabbitmq.client.Envelope;
import com.rabbitmq.client.ShutdownSignalException;
import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

public class QueueConsumer extends EndPoint implements Runnable, Consumer{

    public QueueConsumer(String endPointName) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        super(endPointName);
    }

    public void Run(){
        try{
            channel.basicConsume(endPointName, true, (com.rabbitmq.client.Consumer) this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void handleConsumeOk(String consumerTag){
        System.out.println("Consumer" + consumerTag + "registered");
    }

    public void handleDelivery(String consumerTag, Envelope env,
                               BasicProperties props, byte[] body){
        Map map = (HashMap) SerializationUtils.deserialize(body);
        System.out.println("Message number" + map.get("Message number") +"recieved");
    }

    public void handleCancel(String consumerTag){}
    public void handleCancelOk(String consumerTag) {}
    public void handleRecoverOk(String consumerTag) {}
    public void handleShutdownSignal(String consumerTag, ShutdownSignalException arg1) {}

    @Override
    public void run() {

    }

    @Override
    public void accept(Object o) {

    }
}

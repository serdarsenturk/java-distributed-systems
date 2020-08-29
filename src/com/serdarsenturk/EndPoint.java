package com.serdarsenturk;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public abstract class EndPoint {
    protected Channel channel;
    protected Connection connection;
    protected String endPointName;

    public EndPoint(String endPointName) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        this.endPointName = endPointName;

        ConnectionFactory factory = new ConnectionFactory();

        factory.setUri("amqps://ymmlbeft:IPSFfJDg35dEtLtQttfQNKnIw0XCRokl@sparrow.rmq.cloudamqp.com/ymmlbeft");

        connection = factory.newConnection();

        channel = connection.createChannel();

        channel.queueDeclare(endPointName, false, false, false, null);
    }

    public void close() throws IOException, TimeoutException {
        this.connection.close();
        this.channel.close();
    }


}

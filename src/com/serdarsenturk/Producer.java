package com.serdarsenturk;

import org.apache.commons.lang3.SerializationUtils;

import java.io.IOException;
import java.io.Serializable;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.TimeoutException;

public class Producer extends EndPoint {
    public  Producer(String endPointName) throws IOException, TimeoutException, NoSuchAlgorithmException, KeyManagementException, URISyntaxException {
        super(endPointName);
    }

    public void sendMessage(Serializable object) throws IOException{
        channel.basicPublish("", endPointName, null, SerializationUtils.serialize(object));
    }
}

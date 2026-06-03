package com.example;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;

public class Client {

    

    public void Client()
    {

    }

    public void startClient()
    {
        try{
        MqttClient client = new MqttClient(
        "tcp://localhost:1883", //URL
        MqttClient.generateClientId(), //ClientId
        new MemoryPersistence()); //Persistence
        System.out.println("Client creato con successo");
        client.connect();
        System.out.println("Client connesso al broker");
        client.isConnected();
        System.out.println("Client è connesso: " + client.isConnected());
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    
    }
} 

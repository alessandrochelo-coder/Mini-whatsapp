package com.example;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import java.util.Scanner;

public class ClientPublisher{
    
MqttClient clientP;
boolean running = false;

    public ClientPublisher()
    {

    }

    public boolean getRunning() 
    {
    return running;
    }

    public void setRunning(boolean running1)
    {
    this.running = running1;
    }

    public void startPublisher()
    {
        try
        {
            clientP = new MqttClient(
                    "tcp://localhost:1883", // URI
                    MqttClient.generateClientId(), // ClientId
                    new MemoryPersistence()); // Persistence
            System.out.println("PUB Client creato con successo");


            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);

            clientP.connect(options);
            System.out.println("PUB Client connesso al broker");
            System.out.println("PUBClient è connesso: " + clientP.isConnected());
            String contenuto = "Mio Messaggio";
            org.eclipse.paho.client.mqttv3.MqttMessage messaggio = new org.eclipse.paho.client.mqttv3.MqttMessage(contenuto.getBytes());

            
            System.out.println("running: " + running);

             while(running)
             {
               try{
                Thread.sleep(5000); // Attende 5 secondi prima di pubblicare il prossimo messaggio
                clientP.publish("test", messaggio); // Pubblica nuovamente sul topic "test"
                System.out.println("Messaggio pubblicato con successo!");
               }catch(Exception e)
               {
                System.out.println("Errore durante la pubblicazione: " + e.getMessage());
               }
               
             }
        

        }catch(Exception e)
        {
            System.out.println("Errore: " + e.getMessage());
        }
    }

    public void stopPublisher()
    {
        try{
            clientP.disconnect();
            clientP.close();
            System.out.println("PUBSClient disconnesso");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
    }
}

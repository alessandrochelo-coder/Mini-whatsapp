package com.example;

import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import java.util.Scanner;

public class Client implements MqttCallback {

MqttClient client;

boolean running = false;

public boolean getRunning() 
{
    return running;
}

public void setRunning(boolean running1)
{
    this.running = running1;
}

            @Override
            public void connectionLost(Throwable cause) {
                System.out.println("Connessione persa: " + cause.getMessage());
            }

            @Override
            public void messageArrived(String t, MqttMessage m) {
                System.out.println("Ricevuto: " + new String(m.getPayload()));
            }

            @Override
            public void deliveryComplete(IMqttDeliveryToken token) {
                System.out.println("Consegna completata");
            }

    public Client()
    {

    }

    public void startCliente()
    {

        Scanner scanner = new Scanner(System.in);

        try {
             client = new MqttClient(
                    "tcp://localhost:1883", // URI
                    MqttClient.generateClientId(), // ClientId
                    new MemoryPersistence()); // Persistence
            System.out.println("SUB Client creato con successo");
            client.setCallback(this);

            MqttConnectOptions options = new MqttConnectOptions();
            options.setAutomaticReconnect(true);
            options.setCleanSession(true);

            client.connect(options);
            System.out.println("SUB Client connesso al broker");
            System.out.println("SUBClient è connesso: " + client.isConnected());
            client.subscribe("test");
            System.out.println("SUB Sottoscritto a test. In attesa dei messaggi... running: " + running);
            //scanner.nextLine();
            // new java.util.Scanner(System.in).nextLine();
            while(running)
            { 
                try{
                    Thread.sleep(5000);
                    System.out.println("SUB Prova di stampa ogni 5 secondi per verificare che il thread sia attivo...");
                }catch(InterruptedException e)
                {
                    e.printStackTrace();
                }
                
            }
            

        } catch(Exception e) {
            e.printStackTrace();
        }
    
        scanner.close();

    }
public void stopCliente()
        {
            try{
                client.disconnect();
            client.close();
            System.out.println("SUBClient disconnesso");
            }catch(Exception e)
            {
                e.printStackTrace();
            }
        }



    
} 

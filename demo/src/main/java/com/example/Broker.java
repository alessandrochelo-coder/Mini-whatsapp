package com.example;

import java.io.IOException;
import java.util.Properties;

import io.moquette.broker.Server;
import io.moquette.broker.config.MemoryConfig;



public class Broker {

      public Broker()
      {
         
      }

     public void startBroker()
     {
          try{
          Server broker = new Server();
        Properties config = new Properties();
        config.setProperty("port", "1883");
        config.setProperty("host", "0.0.0.0");
        broker.startServer(new MemoryConfig(config));
        System.out.println("Broker avviato sulla porta 1883");
        // broker.stopServer(); per fermarlo
          }catch(IOException e)
          {
              e.printStackTrace();
          }
     } 

}

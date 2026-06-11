package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       

       Broker broker = new Broker();
       broker.startBroker();

       
       //Client cliente = new Client(); 
       //cliente.setRunning(true);
       //cliente.startCliente();
      

       ClientPublisher publisher = new ClientPublisher();
        publisher.setRunning(true);
       publisher.startPublisher(); 
      

       System.out.println("Premi INVIO per terminare...");

       if(scanner.hasNextLine())
       {
        scanner.nextLine();
       // cliente.setRunning(false);
        publisher.setRunning(false);
       }
       System.out.println("Il programma continua correttamente!");

       

       publisher.stopPublisher();
       // cliente.stopCliente();

       broker.stopBroker();
       System.out.println("Broker disconnesso");
       scanner.close();
    }
}
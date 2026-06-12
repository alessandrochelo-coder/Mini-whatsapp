package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       

       Broker broker = new Broker();
       System.out.println("Creazione del broker...");
       broker.startBroker();
       System.out.println("Avvio del broker completato!");
       
       Client cliente = new Client(); 
       System.out.println("Creazione del client...");
       cliente.setRunning(true);
       System.out.println("Imposto a true il running del client...");
       cliente.startCliente();
       System.out.println("Avvio del client...");

       ClientPublisher publisher = new ClientPublisher();
       System.out.println("Creazione del publisher...");
       publisher.setRunning(true);
       System.out.println("Imposto a true il running del publisher...");
       publisher.run(); 
       System.out.println("Avvio del publisher...");
      

       System.out.println("Premi INVIO per terminare...");

       if(scanner.hasNextLine())
       {
        scanner.nextLine();
        cliente.setRunning(false);
        publisher.setRunning(false);
       }
       System.out.println("Il programma continua correttamente!");

       

       publisher.stopPublisher();
        cliente.stopCliente();

       broker.stopBroker();
       System.out.println("Broker disconnesso");
       scanner.close();
    }
}
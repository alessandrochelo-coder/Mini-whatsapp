package com.example;

public class Main {
    public static void main(String[] args) {
       
       Broker broker = new Broker();
       broker.startBroker();
       Client cliente = new Client();
       cliente.startClient();
    }
}
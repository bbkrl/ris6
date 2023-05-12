package com.company.service;

import javax.xml.ws.Endpoint;

public class SOAPPublisher {

    public static void main(String[] args) {

        Endpoint.publish("http://localhost:8080/ws/theatres", new TheatreServiceImpl());
    }

}
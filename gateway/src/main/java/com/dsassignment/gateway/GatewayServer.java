package com.dsassignment.gateway;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import javax.xml.ws.Endpoint;

public class GatewayServer {

    public static void main(String[] args) {
        // 1. Connect to the gRPC server as a client
        ManagedChannel channel = ManagedChannelBuilder
                .forAddress("localhost", 9090)
                .usePlaintext()
                .build();

        // 2. Create the SOAP service implementation, wired to the gRPC channel
        HotelBookingSoapServiceImpl serviceImpl = new HotelBookingSoapServiceImpl(channel);

        // 3. Publish it as a SOAP endpoint — WSDL will be auto-generated
        String address = "http://localhost:8080/hotelbooking";
        Endpoint.publish(address, serviceImpl);

        System.out.println("Gateway SOAP endpoint published at: " + address);
        System.out.println("WSDL available at: " + address + "?wsdl");
        System.out.println("Make sure grpc-server (port 9090) is running first!");
    }
}
package com.dsassignment.grpc.server;

import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class HotelBookingServer {

    public static void main(String[] args) throws IOException, InterruptedException {
        int port = 9090;

        Server server = ServerBuilder.forPort(port)
                .addService(new HotelBookingServiceImpl())
                .build();

        server.start();
        System.out.println("HotelBookingServer started, listening on port " + port);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("Shutting down gRPC server...");
            server.shutdown();
        }));

        server.awaitTermination();
    }
}

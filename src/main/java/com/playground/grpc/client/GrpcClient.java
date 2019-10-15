package com.playground.grpc.client;

import com.playground.grpc.HelloRequest;
import com.playground.grpc.HelloResponse;
import com.playground.grpc.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {
    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Natan")
                .setLastName("Severo")
                .build());

        System.out.println(helloResponse.getGreeting());

        channel.shutdown();
    }
}

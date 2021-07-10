package io.github.leeseojune53.grpc_server;

import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.examples.lib.GreeterGrpc;
import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MapFieldEntry;
import net.devh.boot.grpc.server.service.GrpcService;

@Slf4j
@GrpcService
public class GreeterService extends GreeterGrpc.GreeterImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String message = "SERVER 1 - Hello" + request.getName();

        MapFieldEntry mapFieldEntry = MapFieldEntry.newBuilder()
                .setName(request.getName())
                .setResult(true)
                .build();

        final HelloReply.Builder replyBuilder = HelloReply.newBuilder().setResult(mapFieldEntry);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
        log.info("SERVER 1 - Returning" + message);


    }
}

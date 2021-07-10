package io.github.leeseojune53.grpc;

import io.grpc.StatusRuntimeException;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.examples.lib.GreeterGrpc;
import net.devh.boot.grpc.examples.lib.HelloReply;
import net.devh.boot.grpc.examples.lib.HelloRequest;
import net.devh.boot.grpc.examples.lib.MapFieldEntry;
import org.springframework.stereotype.Service;

@Service
public class GreeterService {

    @GrpcClient("local-grpc-server")
    private GreeterGrpc.GreeterBlockingStub greeterStub;

    public MapFieldEntry hello(final String name) {
        try {
            final HelloReply response =
                    this.greeterStub.sayHello(HelloRequest.newBuilder().setName(name).build());
            return response.getResult();
        } catch (final StatusRuntimeException e) {
            return MapFieldEntry.newBuilder().setResult(false).build();
        }
    }

}

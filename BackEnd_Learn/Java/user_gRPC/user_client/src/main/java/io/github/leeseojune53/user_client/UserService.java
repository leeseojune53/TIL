package io.github.leeseojune53.user_client;

import io.github.leeseojune53.proto.UserEntry;
import io.github.leeseojune53.proto.UserGrpc;
import io.github.leeseojune53.proto.UserReply;
import io.github.leeseojune53.proto.UserRequest;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Slf4j
@Service
public class UserService {

    @GrpcClient("local-grpc-server")
    private UserGrpc.UserBlockingStub userStub;

    public UserEntry getUser(int id) {
        try{
            log.info("call");
            UserReply reply = userStub.getUser(UserRequest.newBuilder().setUserId(id).build());
            log.info("response");

            return reply.getResult();
        } catch (final StatusRuntimeException e) {
            return UserEntry.newBuilder().setResult(false).build();
        }
    }

}

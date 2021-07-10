package io.github.leeseojune53.user_grpc;

import io.github.leeseojune53.proto.UserEntry;
import io.github.leeseojune53.proto.UserGrpc;
import io.github.leeseojune53.proto.UserReply;
import io.github.leeseojune53.proto.UserRequest;
import io.github.leeseojune53.user_grpc.entity.User;
import io.github.leeseojune53.user_grpc.entity.UserRepository;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

@Service
@GrpcService
@RequiredArgsConstructor
public class UserServiceImpl extends UserGrpc.UserImplBase implements UserService{

    private final UserRepository userRepository;

    @Override
    public void getUser(UserRequest request, StreamObserver<UserReply> responseObserver) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow();

        UserEntry userEntry = UserEntry.newBuilder()
                .setResult(true)
                .setUserId(user.getId())
                .setUserName(user.getName())
                .build();

        final UserReply.Builder replyBuilder = UserReply.newBuilder().setResult(userEntry);

        responseObserver.onNext(replyBuilder.build());
        try{
            Thread.sleep(1000);
        }catch (Exception e) {
            throw new RuntimeException();
        }
        responseObserver.onCompleted();
    }

    @Override
    public void writeUser(String name) {
        userRepository.save(
                User.builder()
                .name(name)
                .build()
        );
    }
}

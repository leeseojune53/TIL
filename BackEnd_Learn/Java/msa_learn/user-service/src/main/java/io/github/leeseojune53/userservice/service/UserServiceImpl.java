package io.github.leeseojune53.userservice.service;

import com.google.protobuf.util.JsonFormat;
import io.github.leeseojune53.proto.*;
import io.github.leeseojune53.userservice.dto.PostResponse;
import io.github.leeseojune53.userservice.entity.User;
import io.github.leeseojune53.userservice.entity.UserRepository;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@GrpcService
@RequiredArgsConstructor
public class UserServiceImpl extends UserGrpc.UserImplBase implements UserService {

    private final UserRepository userRepository;

    @GrpcClient("post-server")
    private PostGrpc.PostBlockingStub postStub;

    @Override
    public void register(String name) {
        userRepository.save(
                User.builder()
                .name(name)
                .build()
        );
    }

    @Override
    public List<PostResponse> getUserPost(Integer id) {
        PostReply reply = postStub.getPost(PostRequest.newBuilder().setUserId(id).build());

        try {
            return reply.getResultList().stream()
                    .map(PostResponse::new)
                    .collect(Collectors.toList());
        } catch(StatusRuntimeException e) {
            return null;
        }
    }

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
        responseObserver.onCompleted();
    }
}

package io.github.leeseojune53.postservice.service;

import io.github.leeseojune53.postservice.dto.WriteRequest;
import io.github.leeseojune53.postservice.entity.Post;
import io.github.leeseojune53.postservice.entity.PostRepository;
import io.github.leeseojune53.proto.*;
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
public class PostServiceImpl extends PostGrpc.PostImplBase implements PostService {

    @GrpcClient("user-server")
    private UserGrpc.UserBlockingStub userStub;

    private final PostRepository postRepository;

    @Override
    public void writeRequest(WriteRequest request) {
        postRepository.save(
                Post.builder()
                .userId(request.getId())
                .value(request.getValue())
                .build()
        );
    }

    @Override
    public void getPost(PostRequest request, StreamObserver<PostReply> responseObserver) {
        List<Post> post = postRepository.findAllByUserId(request.getUserId());


        List<PostEntry> entry = post.stream()
                .map(post1 -> {
                    UserEntry userEntry = userStub.getUser(UserRequest.newBuilder().setUserId(post1.getUserId()).build())
                            .getResult();
                    return PostEntry.newBuilder()
                                    .setResult(true)
                                    .setUserId(post1.getUserId())
                                    .setUserName(userEntry.getUserName())
                                    .setValue(post1.getValue())
                                    .build();
                        }
                )
                .collect(Collectors.toList());

        final PostReply.Builder replyBuilder = PostReply.newBuilder().addAllResult(entry);
        responseObserver.onNext(replyBuilder.build());
        responseObserver.onCompleted();
    }
}

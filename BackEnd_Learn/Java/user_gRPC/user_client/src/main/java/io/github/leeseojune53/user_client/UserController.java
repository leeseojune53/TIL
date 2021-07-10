package io.github.leeseojune53.user_client;

import io.github.leeseojune53.proto.UserEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/user")
    public ResponseEntity<?> user(int id) {
        UserEntry entry = userService.getUser(id);

        if(entry!= null && entry.getResult()){
            return ResponseEntity.ok(entry.getUserName());
        }else {
            return ResponseEntity.badRequest().build();
        }
    }


}

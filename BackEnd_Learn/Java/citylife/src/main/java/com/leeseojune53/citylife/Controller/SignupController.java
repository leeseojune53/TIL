package com.leeseojune53.citylife.Controller;


import com.leeseojune53.citylife.Payload.Request.SignRequest;
import com.leeseojune53.citylife.Security.JwtTokenProvider;
import com.leeseojune53.citylife.Service.Signup.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/Signup")
public class SignupController {
    private final SignupService signupService;
    private final JwtTokenProvider jwtTokenProvider;

    @GetMapping("/checkSignup")
    public boolean checkSignup(String userId){
        return signupService.isAlreadySignupService(userId);
    }

//    @GetMapping("/login")
//    public boolean login(String userId, String userPw){
//
//    }

    @PostMapping("/Signup")
    public boolean userSignup(@RequestBody SignRequest request){
        return signupService.userSignupService(request);
    }
}

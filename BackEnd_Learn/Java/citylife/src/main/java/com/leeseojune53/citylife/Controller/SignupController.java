package com.leeseojune53.citylife.Controller;


import com.leeseojune53.citylife.Payload.Request.SignRequest;
import com.leeseojune53.citylife.Service.SignupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/Signup")
public class SignupController {
    private final SignupService signupService;

    @GetMapping("/checkSignup")
    public boolean checkSignup(Long id){
        return signupService.isAlreadySignupService(id);
    }

    @PostMapping("/Signup")
    public boolean userSignup(@RequestBody SignRequest request){
        return signupService.userSignupService(request);
    }
}

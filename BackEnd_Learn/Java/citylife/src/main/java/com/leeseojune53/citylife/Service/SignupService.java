package com.leeseojune53.citylife.Service;

import com.leeseojune53.citylife.Payload.Request.SignRequest;

public interface SignupService {
    public boolean userSignupService(SignRequest request);
    public boolean isAlreadySignupService(Long id);
}

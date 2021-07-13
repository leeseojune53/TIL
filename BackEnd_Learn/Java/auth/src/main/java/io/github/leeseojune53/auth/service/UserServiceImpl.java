package io.github.leeseojune53.auth.service;

import io.github.leeseojune53.auth.dto.UserAuthRequest;
import io.github.leeseojune53.auth.dto.UserRegisterRequest;
import io.github.leeseojune53.auth.entity.user.Role;
import io.github.leeseojune53.auth.entity.user.User;
import io.github.leeseojune53.auth.entity.user.UserRepository;
import io.github.leeseojune53.auth.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    public void userRegister(UserRegisterRequest registerRequest) {
        User newUser = User.builder()
                .name(registerRequest.getName())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .build();

        newUser.getRoles().add(Role.ROLE_ADMIN);

        userRepository.save(newUser);
    }

    @Override
    public String getAccessToken(UserAuthRequest authRequest) {
        return jwtTokenProvider.generateAccessToken(authRequest.getName());
    }
}

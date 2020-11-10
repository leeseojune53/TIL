package com.example.jwt.Security.Jwt.Auth;

import com.example.jwt.Entity.User.UserRepository;
import com.example.jwt.Exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetail loadUserByUsername(String id) throws UsernameNotFoundException {
        return userRepository.findById(Integer.parseInt(id))
                .map(User->
                    new AuthDetail(User.getUserId(), User.getUserPw(), User.getAuthority())
                ).orElseThrow(UserNotFoundException::new);
    }
}

package com.example.jwtpractice.Security;

import com.example.jwtpractice.Exception.UserNotFoundException;
import com.example.jwtpractice.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public AuthDetails loadUserByUsername(String usercode) throws UsernameNotFoundException {
        return userRepository.findById(Integer.parseInt(usercode))
                .map(AuthDetails::new)
                .orElseThrow(UserNotFoundException::new);
    }
}

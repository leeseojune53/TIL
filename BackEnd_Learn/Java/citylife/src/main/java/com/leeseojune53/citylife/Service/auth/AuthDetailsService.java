package com.leeseojune53.citylife.Service.auth;

import com.leeseojune53.citylife.Exceptions.UserNotFoundExceptions;
import com.leeseojune53.citylife.Repository.UserRepository;
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
    public AuthDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUserId(username)
                .map(
                        user->{
                            return new AuthDetails(user.getUserId(), user.getUserPw());
                        })
                .orElseThrow(UserNotFoundExceptions::new);
    }
}

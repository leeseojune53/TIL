package com.dsm.daily_book.security.jwt.auth;

import com.dsm.daily_book.entity.user.UserRepository;
import com.dsm.daily_book.exception.user.UserNotFoundException;
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
    public AuthDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        return userRepository.findById(Integer.parseInt(userId))
                .map(AuthDetails::new)
                .orElseThrow(UserNotFoundException::new);
    }
}

package com.dsm.daily_book.service.user;

import com.dsm.daily_book.dto.UserDTO;
import com.dsm.daily_book.dto.TokenDTO;
import com.dsm.daily_book.entity.email.EmailVerification;
import com.dsm.daily_book.entity.email.EmailVerificationRepository;
import com.dsm.daily_book.entity.email.EmailVerificationStatus;
import com.dsm.daily_book.entity.user.JwtToken;
import com.dsm.daily_book.entity.user.JwtTokenRepository;
import com.dsm.daily_book.entity.user.User;
import com.dsm.daily_book.entity.user.UserRepository;
import com.dsm.daily_book.exception.email.InvalidAuthCodeException;
import com.dsm.daily_book.exception.jwt.InvalidTokenException;
import com.dsm.daily_book.exception.user.ExpiredAuthCodeException;
import com.dsm.daily_book.exception.email.InvalidAuthEmailException;
import com.dsm.daily_book.exception.user.UserAlreadyExistException;
import com.dsm.daily_book.exception.user.UserNotFoundException;
import com.dsm.daily_book.security.jwt.AuthenticationFacade;
import com.dsm.daily_book.security.jwt.JwtTokenProvider;
import com.dsm.daily_book.service.mail.EmailService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final JwtTokenRepository jwtTokenRepository;
    private final EmailService emailService;
    private final EmailVerificationRepository emailVerificationRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtProvider;
    private final AuthenticationFacade authenticationFacade;

    @Value("${jwt.exp.refresh}")
    private Long refreshExp;

    @Override
    public void sendAuthCode(UserDTO.mail request) {
        log.info("Send email : " + request.getEmail());
        String code = randomCode();

        userRepository.findByEmail(request.getEmail())
                .ifPresent(user -> {
                    throw new UserAlreadyExistException();
                });

        emailService.sendEmail(request.getEmail(), code);

        emailVerificationRepository.save(EmailVerification.builder()
                .email(request.getEmail())
                .status(EmailVerificationStatus.UNVERIFIED)
                .authCode(code)
                .build()
        );
    }

    @Override
    public void verifyAuthCode(UserDTO.authCode request) {
        String code = request.getCode();
        EmailVerification emailVerification = emailVerificationRepository.findById(request.getEmail())
                .orElseThrow(InvalidAuthEmailException::new);

        if(!emailVerification.getAuthCode().equals(code))
            throw new InvalidAuthCodeException();

        emailVerification.verify();
        emailVerificationRepository.save(emailVerification);

        log.info("auth Success Email : " + request.getEmail());
    }

    @Override
    public void register(UserDTO.register request) {
        log.info("Register email : " + request.getEmail());
        emailVerificationRepository.findById(request.getEmail())
                .filter(EmailVerification::isVerified)
                .orElseThrow(ExpiredAuthCodeException::new);

        userRepository.save(
                User.builder()
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .nickname(request.getNickname())
                .build()
        );
    }

    @Override
    public TokenDTO.token auth(UserDTO.auth request) { // 로그인
        log.info("auth email : " + request.getEmail());
        return userRepository.findByEmail(request.getEmail())
                .filter(user -> passwordEncoder.matches(request.getPassword(), user.getPassword()))
                .map(User::getUser_code)
                .map(userCode->{
                    try{
                        authenticationManager.authenticate(request.getAuthToken(userCode));
                    }catch (Exception e) {
                        throw new InvalidTokenException();
                    }
                    String accessToken = jwtProvider.generateAccessToken(userCode);
                    String refreshToken = jwtProvider.generateRefreshToken(userCode);
                    jwtTokenRepository.save(
                            JwtToken.builder()
                            .email(request.getEmail())
                            .refreshToken(refreshToken)
                            .ttl(refreshExp)
                            .build()
                    );
                    return new TokenDTO.token(accessToken, refreshToken);
                })
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void changeNickname(UserDTO.changeNickname request) {
        User user = getUser();
        user.setNickname(request.getNickname());
        userRepository.save(user);
        log.info("nickname change email : " + user.getEmail());
    }

    private String randomCode() {
        StringBuilder result = new StringBuilder();
        String[] codes = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789".split("");

        for(int i=0;i<6;i++){
            result.append(codes[new Random().nextInt(codes.length)]);
        }

        log.info("randomCode: " + result.toString());
        return result.toString();
    }

    private User getUser(){
        return authenticationFacade.getUser();
    }
}

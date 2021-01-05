package com.example.codeverify.service;

import com.example.codeverify.Payload.AuthCode;
import com.example.codeverify.Payload.EmailRequest;
import com.example.codeverify.Payload.request.Signup;
import com.example.codeverify.entity.user.User;
import com.example.codeverify.entity.user.UserRepository;
import com.example.codeverify.exception.ExpiredAuthCodeException;
import com.example.codeverify.exception.UserAlreadyExistException;
//import com.example.codeverify.mail.MailService;
import com.example.codeverify.mail.Sender;
import com.example.codeverify.mail.SenderDto;
import com.example.codeverify.verification.EmailVerification;
import com.example.codeverify.verification.EmailVerificationRepository;
import com.example.codeverify.verification.EmailVerificationStatus;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final EmailVerificationRepository emailVerificationRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final Sender sender;


    public String randomCode() {
        StringBuilder result = new StringBuilder();
        String[] codes = "QWERTYUIOPASDFGHJKLZXCVBNM0123456789".split("");

        for(int i=0;i<6;i++){
            result.append(codes[new Random().nextInt(codes.length)]);
        }

        log.info("randomCode: " + result.toString());
        return result.toString();
    }

    @Override
    public void sendAuthCode(EmailRequest request) { // 코드 발송
        String code = randomCode();

        userRepository.findByEmail(request.getEmail())
                .ifPresent(user ->{
                    throw new UserAlreadyExistException();
        });

        List list = new ArrayList();
        list.add(request.getEmail());
        SenderDto dto = SenderDto.builder()
                .from("wasabi53535@gmail.com")
                .to(list)
                .subject("codeverify 인증코드 : " + code)
                .content(code).build();
        sender.send(dto);

        emailVerificationRepository.save(
                EmailVerification.builder()
                        .email(request.getEmail())
                        .authCode(code)
                        .status(EmailVerificationStatus.UNVERIFIED)
                        .build()
        );

    }

    @Override
    public void authCode(AuthCode authCode) { // 코드 확인, 인증
        String code = authCode.getAuthCode();
        EmailVerification emailVerification = emailVerificationRepository.findById(authCode.getEmail())
                .orElseThrow(NullPointerException::new);
        if(!emailVerification.getAuthCode().equals(code)){
            throw new RuntimeException();
        }

        emailVerification.verify();
        emailVerificationRepository.save(emailVerification);
        log.info("auth Success User_mail : " + authCode.getEmail());
    }

    @Override
    public void signup(Signup signup) {
        String email = signup.getEmail();
        String password = passwordEncoder.encode(signup.getPassword());
        emailVerificationRepository.findById(email)
                .filter(EmailVerification::isVerified)
                .orElseThrow(ExpiredAuthCodeException::new);

        userRepository.save(
                User.builder()
                .email(email)
                .password(password)
                .build()
        );
        log.info("Signup Success User_amil : " + email);
    }
}

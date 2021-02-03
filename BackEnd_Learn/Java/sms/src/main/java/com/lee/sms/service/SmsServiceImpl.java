package com.lee.sms.service;

import com.lee.sms.dto.PhoneDTO;
import com.lee.sms.dto.UserDTO;
import com.lee.sms.entity.verify.Verify;
import com.lee.sms.entity.verify.VerifyRepository;
import com.lee.sms.entity.verify.VerifyStatus;
import com.lee.sms.entity.user.User;
import com.lee.sms.entity.user.UserRepository;
import com.lee.sms.exception.ExpiredAuthCode;
import com.lee.sms.exception.NumberNotExist;
import com.lee.sms.exception.UserSave;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.nurigo.java_sdk.api.Message;
import net.nurigo.java_sdk.exceptions.CoolsmsException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
@Slf4j
public class SmsServiceImpl implements SmsService{

    private final VerifyRepository numberRepository;
    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Value("${sms.apikey}")
    private String API_KEY;

    @Value("${sms.secret}")
    private String API_SEC;

    @Value("${sms.num}")
    private String NUM;

    @Override
    public void send(String phone, String numStr) {

        Message coolSms = new Message(API_KEY, API_SEC);

        HashMap<String, String> params = new HashMap<>();
        params.put("to", phone);
        params.put("from", NUM);
        params.put("type", "SMS");
        params.put("text", "SMS 인증번호 [" + numStr + "]");
        params.put("app_version", "app 0.0");

        try{
            numberRepository.save(
                    Verify.builder()
                    .phone(phone)
                    .number(numStr)
                    .status(VerifyStatus.UNVERIFIED)
                    .build()
                    );
            JSONObject obj = coolSms.send(params);
            log.info(obj.toString());
        }catch (CoolsmsException e){
            log.error(e.getMessage());
            log.error(String.valueOf(e.getCode()));
        }

    }

    @Override
    public void verify(PhoneDTO.Verify request) {
        Verify number = numberRepository.findById(request.getPhone())
                .orElseThrow(NumberNotExist::new);

        if(!number.getNumber().equals(request.getNumStr()))
            throw new NumberNotExist();

        number.verify();
        numberRepository.save(number);

        log.info("auth Success : " + request.getPhone());
    }

    @Override
    public void register(UserDTO.UserInfo request) {
        numberRepository.findById(request.getPhone())
                .filter(Verify::isVerified)
                .orElseThrow(ExpiredAuthCode::new);

        try{
            userRepository.save(
                    User.builder()
                            .name(request.getName())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .phone(request.getPhone())
                            .build()
            );
        }catch (Exception e){
            throw new UserSave();
        }

        log.info("register Success : " + request.getName());
    }
}

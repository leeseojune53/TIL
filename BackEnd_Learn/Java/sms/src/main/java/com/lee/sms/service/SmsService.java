package com.lee.sms.service;

import com.lee.sms.dto.PhoneDTO;
import com.lee.sms.dto.UserDTO;

public interface SmsService {
    void send(String phone, String numStr);
    void verify(PhoneDTO.Verify request);
    void register(UserDTO.UserInfo request);
}

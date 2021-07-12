package io.github.leeseojune53.auth.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserAuthRequest {

    private String name;
    private String password;

}

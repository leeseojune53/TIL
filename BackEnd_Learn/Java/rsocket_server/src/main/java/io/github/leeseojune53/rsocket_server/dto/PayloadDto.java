package io.github.leeseojune53.rsocket_server.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PayloadDto {
    private String message;
    private String roomName;
}

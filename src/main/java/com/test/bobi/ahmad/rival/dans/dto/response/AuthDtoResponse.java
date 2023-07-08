package com.test.bobi.ahmad.rival.dans.dto.response;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthDtoResponse {
    private String token;
    private Date validity;
}

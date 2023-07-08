package com.test.bobi.ahmad.rival.dans.dto.request;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AuthDtoRequest {
    private String username;
    private String password;
}

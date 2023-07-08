package com.test.bobi.ahmad.rival.dans.dto.response;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserDtoResponse {
    private Long id;
    private String username;
    private String password;
}

package com.test.bobi.ahmad.rival.dans.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class GenerateTokenDto {
    private String token;
    private Date validity;
}

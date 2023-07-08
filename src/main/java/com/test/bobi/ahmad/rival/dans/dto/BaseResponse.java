package com.test.bobi.ahmad.rival.dans.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.sql.Timestamp;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseResponse<T> {
    private Integer code;
    private String message;
    private T data;

    @Builder.Default
    private Date dateTime = new Date();
}

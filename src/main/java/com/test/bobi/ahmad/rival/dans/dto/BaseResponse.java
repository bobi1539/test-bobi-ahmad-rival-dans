package com.test.bobi.ahmad.rival.dans.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.test.bobi.ahmad.rival.dans.util.Util;
import lombok.*;

import java.sql.Timestamp;
import java.util.Map;

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
    private Timestamp timestamp = Util.timestampNow();
    private Map<String, Object> errors;
}

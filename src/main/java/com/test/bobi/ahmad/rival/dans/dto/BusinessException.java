package com.test.bobi.ahmad.rival.dans.dto;

import com.test.bobi.ahmad.rival.dans.constant.GlobalMessage;
import lombok.*;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BusinessException extends RuntimeException {
    private HttpStatus code;
    private String message;

    public BusinessException(GlobalMessage globalMessage){
        super(globalMessage.message);
        this.code = globalMessage.code;
        this.message = globalMessage.message;
    }
}

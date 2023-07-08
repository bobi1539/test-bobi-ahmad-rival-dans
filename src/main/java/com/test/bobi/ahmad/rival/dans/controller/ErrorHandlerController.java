package com.test.bobi.ahmad.rival.dans.controller;

import com.test.bobi.ahmad.rival.dans.dto.BaseResponse;
import com.test.bobi.ahmad.rival.dans.dto.BusinessException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@AllArgsConstructor
@Slf4j
public class ErrorHandlerController {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exception(Exception e) {
        log.error("Error : {}", e);
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                        .message(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                        .build(),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<?> businessException(BusinessException e) {
        log.error("Error : {}", e);
        return new ResponseEntity<>(
                BaseResponse.builder()
                        .code(e.getCode().value())
                        .message(e.getMessage())
                        .build(),
                e.getCode()
        );
    }
}

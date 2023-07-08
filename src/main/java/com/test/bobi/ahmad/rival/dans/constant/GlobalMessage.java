package com.test.bobi.ahmad.rival.dans.constant;

import org.springframework.http.HttpStatus;

public enum GlobalMessage {

    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "Unautorized"),
    DATA_NOT_FOUND(HttpStatus.NOT_FOUND, "Data Not Found");

    public HttpStatus code;
    public String message;

    GlobalMessage(HttpStatus code, String message) {
        this.code = code;
        this.message = message;
    }
}

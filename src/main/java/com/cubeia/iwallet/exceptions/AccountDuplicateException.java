package com.cubeia.iwallet.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class AccountDuplicateException extends RuntimeException {
    public AccountDuplicateException(String message) {
        super(message);
    }
    public AccountDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }
    public AccountDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

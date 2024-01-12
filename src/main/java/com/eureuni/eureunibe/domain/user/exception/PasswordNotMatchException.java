package com.eureuni.eureunibe.domain.user.exception;

import com.eureuni.eureunibe.global.error.ErrorCode;
import com.eureuni.eureunibe.global.error.exception.ServiceException;

public class PasswordNotMatchException extends ServiceException {
    public PasswordNotMatchException() {
        super(ErrorCode.PASSWORD_NOT_MATCH);
    }
}
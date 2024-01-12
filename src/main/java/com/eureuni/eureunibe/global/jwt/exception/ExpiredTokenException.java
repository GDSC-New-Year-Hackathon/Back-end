package com.eureuni.eureunibe.global.jwt.exception;

import com.eureuni.eureunibe.global.error.ErrorCode;
import com.eureuni.eureunibe.global.error.exception.ServiceException;

public class ExpiredTokenException extends ServiceException {
    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
package com.eureuni.eureunibe.domain.user.exception;

import com.eureuni.eureunibe.global.error.ErrorCode;
import com.eureuni.eureunibe.global.error.exception.ServiceException;

public class EmailDuplicateException extends ServiceException {
    public EmailDuplicateException() {
        super(ErrorCode.EMAIL_DUPLICATE);
    }
}
package com.eureuni.eureunibe.domain.user.exception;

import com.eureuni.eureunibe.global.error.ErrorCode;
import com.eureuni.eureunibe.global.error.exception.ServiceException;

public class UserNotFoundException extends ServiceException {
    public UserNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}

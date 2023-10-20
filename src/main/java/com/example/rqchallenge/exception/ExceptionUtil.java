package com.example.rqchallenge.exception;

import com.example.rqchallenge.enums.ErrorCode;

public class ExceptionUtil {
    public static CustomException getCustomException(ErrorCode errorCode){
        String errorMessage  = ErrorCodeMessageHolder.getErrorMessage(errorCode);
        return new CustomException(errorCode, errorMessage);
    }
}

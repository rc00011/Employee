package com.example.rqchallenge.exception;

import com.example.rqchallenge.bean.ErrorResponse;
import com.example.rqchallenge.enums.ErrorCode;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException customException)
    {
        return new ResponseEntity<>(new ErrorResponse(customException.getErrorCode().getCode(), customException.getErrorMessage()),
                HttpStatus.BAD_REQUEST);
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleCustomException(Exception exception)
    {
        return new ResponseEntity<>(new ErrorResponse(ErrorCode.INTERNAL_SERVER_EXCEPTION.getCode(), ErrorCodeMessageHolder.getErrorMessage(ErrorCode.INTERNAL_SERVER_EXCEPTION)),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

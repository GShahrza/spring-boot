package com.company.usertask.exception;

import com.company.usertask.util.result.ErrorDataResult;
import com.company.usertask.util.result.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public Result handleUserNotFoundException(UserNotFoundException exception){
        return response(exception,444,"User Not Found!");
    }

    @ExceptionHandler
    public Result handleWrongFieldException(WrongFieldException exception){
        return response(exception,330,"Wrong field");
    }

    @ExceptionHandler
    public Result handleAccountNotFoundException(AccountNotFoundException exception){
        return response(exception,444,"Account not found!");
    }

    @ExceptionHandler
    public Result handlePaymentException(PaymentException exception){
        return response(exception,411,"you is poor!");
    }

    private <T extends RuntimeException> Result response(T exception, int code, String message){
        return new ErrorDataResult<>(exception,code,message);
    }
}

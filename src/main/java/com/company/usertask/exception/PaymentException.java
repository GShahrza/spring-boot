package com.company.usertask.exception;

public class PaymentException extends RuntimeException{

    public PaymentException(){
        super();
    }

    public PaymentException(String message){
        super(message);
    }
}

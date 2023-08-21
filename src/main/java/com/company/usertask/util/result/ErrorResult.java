package com.company.usertask.util.result;

public class ErrorResult extends Result{

    public ErrorResult(int code) {
        super(false,code );
    }

    public ErrorResult( int code, String message) {
        super(false, code, message);
    }
}

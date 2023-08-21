package com.company.usertask.util.result;

public class SuccessDataResult<T> extends DataResult<T>{

    public SuccessDataResult() {
        super(null, true, 205);
    }

    public SuccessDataResult(T data) {
        super(data,true, 205);
    }

    public SuccessDataResult(String message) {
        super(null, true ,205, message);
    }

    public SuccessDataResult(T data, String message) {
        super(data, true , 205, message);
    }

}

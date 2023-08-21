package com.company.usertask.util.result;

public class SuccessResult extends Result{

    public SuccessResult(){
        super(true,205);
    }

    public SuccessResult(String message){
        super(true, 205, message);
    }
}

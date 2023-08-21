package com.company.usertask.util.result;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class Result {

    final boolean success;
    final int code;
    String message;

    public Result(boolean success,int code) {
        this.success = success;
        this.code = code;
    }

    public Result(boolean success, int code,String message){
        this(success,code);
        this.message = message;
    }
}

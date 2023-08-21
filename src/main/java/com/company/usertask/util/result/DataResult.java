package com.company.usertask.util.result;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public abstract class DataResult<T> extends Result{

    final T data;

    public DataResult(T data, boolean success, int code) {
        super(success,code);
        this.data = data;
    }

    public DataResult(T data, boolean success, int code, String message) {
        super(success,code, message);
        this.data = data;
    }

}

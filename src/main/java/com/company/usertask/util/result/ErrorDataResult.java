package com.company.usertask.util.result;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ErrorDataResult<T> extends DataResult<T> {

//    LocalDateTime localDateTime
    public ErrorDataResult(int code) {
        super(null, false, code);
    }

    public ErrorDataResult(T data, int code) {
        super(data, false, code);
    }

    public ErrorDataResult(int code, String message) {
        super(null, false, code, message);
    }

    public ErrorDataResult(T data, int code, String message) {
        super(data, false, code, message);
    }


}

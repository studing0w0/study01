package com.study.study01.exception;

import org.springframework.http.HttpStatus;

public enum MemberExceptionType implements BaseExceptionType{

    ALREADY_JOINED_MEMEBER(400, HttpStatus.OK,"이미 가입된 회원입니다.");

    private int errorCode;
    private HttpStatus httpStatus;
    private String errMsg;

    MemberExceptionType(int errorCode, HttpStatus httpStatus, String errMsg){
        this.errorCode = errorCode;
        this.httpStatus = httpStatus;
        this.errMsg = errMsg;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getErrorMessage() {
        return this.errMsg;
    }
}

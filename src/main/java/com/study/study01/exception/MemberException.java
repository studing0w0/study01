package com.study.study01.exception;

public class MemberException extends BaseException{

    private BaseExceptionType baseExceptionType;

    public MemberException(BaseExceptionType baseExceptionType){
        this.baseExceptionType = baseExceptionType;
    }

    @Override
    public BaseExceptionType getExceptionType() {
        return baseExceptionType;
    }


}

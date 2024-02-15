package com.employee.CustomException;

public class NoCompanyExistException extends RuntimeException{

    public NoCompanyExistException(String str){
        super(str);
    }
}

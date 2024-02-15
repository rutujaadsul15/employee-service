package com.employee.CustomException;

public class NoCompanyExistException extends Exception{

    public NoCompanyExistException(String str){
        super(str);
    }
}

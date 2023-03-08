package com.testing.util.exceptions;

public class NotFoundInDataBaseException extends RuntimeException{

    public NotFoundInDataBaseException(String msg){
        super(msg + " not founded in list");
    }

}

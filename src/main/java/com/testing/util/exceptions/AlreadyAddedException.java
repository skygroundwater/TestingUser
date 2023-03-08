package com.testing.util.exceptions;

public class AlreadyAddedException extends RuntimeException{

    public AlreadyAddedException(String msg){
        super(msg + " already added to list");
    }

}

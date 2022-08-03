package com.example.autographEV.exception;

public class RestrictedInfoException extends Exception{
    @Override
    public String getMessage() {
        return "Classified Information";
    }
}

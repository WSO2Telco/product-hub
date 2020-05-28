package com.wso2telco.wum.exceptions;

public class WumException extends Throwable {
    public WumException(String errorMessage) {
        super(errorMessage);
    }
    public WumException(Throwable err) {
        super(err);
    }
}

package com.yi.backcli.exception;

public class ExistsException extends RuntimeException {

    private static final long serialVersionUID = 797333747911832920L;

    public ExistsException(String message) {
        super(message);
    }
}

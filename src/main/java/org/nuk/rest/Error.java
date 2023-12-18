package org.nuk.rest;

public class Error {
    private final String message;
    private final int status;

    public Error(String message, int status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }
}

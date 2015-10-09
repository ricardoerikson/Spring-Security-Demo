package com.trit.security.controllers.response;

public final class ErrorStatus extends HttpResponseStatus {

    private String message;

    public ErrorStatus(String message) {
        super(false);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

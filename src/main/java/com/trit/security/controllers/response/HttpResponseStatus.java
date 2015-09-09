package com.trit.security.controllers.response;

public class HttpResponseStatus {

    private boolean status;

    public HttpResponseStatus(boolean status) {
        this.status = status;
    }

    public String getStatus() {
        return (status == true) ? EStatusDescription.SUCCESS.getValue() : EStatusDescription.ERROR.getValue();
    }

}

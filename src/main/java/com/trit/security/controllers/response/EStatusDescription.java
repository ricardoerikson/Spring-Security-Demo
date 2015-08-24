package com.trit.security.controllers.response;

public enum EStatusDescription {

    SUCCESS("success"), ERROR("error");

    private String description;

    private EStatusDescription(String description) {
        this.description = description;
    }

    public String getValue() {
        return description;
    }

}

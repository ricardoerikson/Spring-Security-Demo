package com.trit.security.controllers.consts;

public enum ERestApi {

    BASE_API("api"), USERS("users");

    private String resource;

    ERestApi(String resource) {
        this.resource = resource;
    }
    
    @Override
    public String toString() {
        return resource;
    }
    
}

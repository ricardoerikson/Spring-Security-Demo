package com.trit.security.utils.ws;

public class WsResource {

    private String resource = null;
    private String id = null;

    public WsResource(String resource) {
        this.resource = resource;
    }

    public WsResource(String resource, String id) {
        this.resource = resource;
        this.id = id;
    }

    @Override
    public String toString() {
        if (resource == null)
            return "";
        if (id == null)
            return String.format("/%s", resource);
        return String.format("/%s/%s", resource, id);
    }

}

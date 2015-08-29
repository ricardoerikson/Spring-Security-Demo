package com.trit.security.utils.ws;

public class WsResource {

    private String resource = null;
    private String id = null;

    public WsResource(String resource) {
        if (resource == null || resource.isEmpty())
            throw new IllegalArgumentException("Argument 'resource' should be neither 'null' nor empty.");
        this.resource = resource;
    }

    public WsResource(String resource, String id) {
        this(resource);
        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("Argument 'id' should be neither 'null' nor empty.");
        this.id = id;
    }

    @Override
    public String toString() {
        if (id == null)
            return String.format("/%s", resource);
        return String.format("/%s/%s", resource, id);
    }

}

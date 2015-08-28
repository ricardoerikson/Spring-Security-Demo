package com.trit.security.utils.ws;

import java.util.LinkedList;
import java.util.List;

public class WsResourceBuilder {

    private List<WsResource> resources;

    private WsResourceBuilder() {
        this.resources = new LinkedList<WsResource>();
    }

    public static WsResourceBuilder resource() {
        return new WsResourceBuilder();
    }

    public WsResourceBuilder add(String resource, String id) {
        resources.add(new WsResource(resource, id));
        return this;
    }

    public WsResourceBuilder add(String resource) {
        resources.add(new WsResource(resource));
        return this;
    }

    public String build() {
        StringBuilder result = new StringBuilder();
        for (WsResource resource : resources) {
            result.append(resource);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String build = WsResourceBuilder.resource().add("api").add("users","1").build();
        System.out.println(build);
    }

}

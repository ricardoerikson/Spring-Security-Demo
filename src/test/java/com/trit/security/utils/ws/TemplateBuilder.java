package com.trit.security.utils.ws;

import java.util.LinkedList;
import java.util.List;

public class TemplateBuilder {

    private List<ResourceTemplate> resources;

    private TemplateBuilder() {
        this.resources = new LinkedList<ResourceTemplate>();
    }

    public static TemplateBuilder template() {
        return new TemplateBuilder();
    }

    public TemplateBuilder res(String resource, String id) {
        resources.add(new ResourceTemplate(resource, id));
        return this;
    }

    public TemplateBuilder res(String resource) {
        resources.add(new ResourceTemplate(resource, false));
        return this;
    }

    public TemplateBuilder var(String variable) {
        resources.add(new ResourceTemplate(variable, true));
        return this;
    }

    public String build() {
        StringBuilder result = new StringBuilder();
        for (ResourceTemplate resource : resources) {
            result.append(resource.template());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String build = TemplateBuilder.template().res("api").res("users", "id").build();
        System.out.println(build);
    }

}

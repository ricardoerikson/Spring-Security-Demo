package com.trit.security.utils.ws;

/**
 * Utility class to build template URIs to access resources.
 * 
 * @author ricardoerikson
 *
 */
public class ResourceTemplate {

    private String resource = null;
    private String variable = null;
    private boolean isVariable = false;

    public ResourceTemplate(String resource, boolean isVariable) {
        if (resource == null || resource.isEmpty())
            throw new IllegalArgumentException("Argument 'resource' should be neither 'null' nor empty.");
        this.resource = resource;
        this.isVariable = isVariable;
    }

    public ResourceTemplate(String resource, String id) {
        this(resource, false);
        if (id == null || id.isEmpty())
            throw new IllegalArgumentException("Argument 'id' should be neither 'null' nor empty.");
        this.variable = id;
    }

    public String template() {
        if (isVariable)
            return String.format("/{%s}", resource);
        if (variable == null)
            return String.format("/%s", resource);
        return String.format("/%s/{%s}", resource, variable);
    }

}

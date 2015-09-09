package com.trit.security.utils.ws;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TemplateBuilderTest {

    @Test
    public void testOnlyOneResourceWithoutId() throws Exception {
        String uri = TemplateBuilder.template().add("users").build();
        Assert.assertEquals("/users", uri);
    }

    @Test
    public void testTwoResourcesWithoutId() throws Exception {
        String uri = TemplateBuilder.template().add("api").add("users").build();
        Assert.assertEquals("/api/users", uri);
    }

    @Test
    public void testTwoResourcesWithIdInTheSecondResource() throws Exception {
        String uri = TemplateBuilder.template().add("api").add("users", "id").build();
        Assert.assertEquals("/api/users/{id}", uri);
    }

    @Test
    public void testOneResourceWithId() throws Exception {
        String uri = TemplateBuilder.template().add("users", "id").build();
        Assert.assertEquals("/users/{id}", uri);
    }

    @Test
    public void testTwoResourcesWithOneIdEach() throws Exception {
        String uri = TemplateBuilder.template().add("api").add("v2").add("users", "id").build();
        Assert.assertEquals("/api/v2/users/{id}", uri);
    }

    @Test
    public void testOneResourceAndOneVariableUsingTheSpecificMethods() throws Exception {
        String uri = TemplateBuilder.template().add("api").var("v1").build();
        Assert.assertEquals("/api/{v1}", uri);
    }

}

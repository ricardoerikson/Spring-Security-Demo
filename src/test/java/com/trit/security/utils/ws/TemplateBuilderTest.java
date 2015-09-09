package com.trit.security.utils.ws;

import org.junit.Assert;
import org.junit.Test;

public class TemplateBuilderTest {

    @Test
    public void testOnlyOneResourceWithoutId() throws Exception {
        String uri = TemplateBuilder.template().res("users").build();
        Assert.assertEquals("/users", uri);
    }

    @Test
    public void testTwoResourcesWithoutId() throws Exception {
        String uri = TemplateBuilder.template().res("api").res("users").build();
        Assert.assertEquals("/api/users", uri);
    }

    @Test
    public void testTwoResourcesWithIdInTheSecondResource() throws Exception {
        String uri = TemplateBuilder.template().res("api").res("users", "id").build();
        Assert.assertEquals("/api/users/{id}", uri);
    }

    @Test
    public void testOneResourceWithId() throws Exception {
        String uri = TemplateBuilder.template().res("users", "id").build();
        Assert.assertEquals("/users/{id}", uri);
    }

    @Test
    public void testTwoResourcesWithOneIdEach() throws Exception {
        String uri = TemplateBuilder.template().res("api").res("v2").res("users", "id").build();
        Assert.assertEquals("/api/v2/users/{id}", uri);
    }

    @Test
    public void testOneResourceAndOneVariableUsingTheSpecificMethods() throws Exception {
        String uri = TemplateBuilder.template().res("api").var("v1").build();
        Assert.assertEquals("/api/{v1}", uri);
    }

    @Test
    public void testTwoVariablesAndOneResourceWithVariable() throws Exception {
        String uri = TemplateBuilder.template().var("year").var("month").res("note", "id").build();
        Assert.assertEquals("/{year}/{month}/note/{id}", uri);
    }

}

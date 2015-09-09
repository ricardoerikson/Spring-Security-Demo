package com.trit.security.utils.ws;

import org.junit.Assert;
import org.junit.Test;

public class TemplateResourceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullResource() {
        new ResourceTemplate(null, false);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullResourceAndNullId() {
        new ResourceTemplate(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGivingAResourceAndNullId() {
        new ResourceTemplate("users", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullResourceGivingAndId() {
        new ResourceTemplate(null, "id");
    }

    @Test
    public void testGivingOnlyAnId() {
        ResourceTemplate resourceTemplate = new ResourceTemplate("id", true);
        String template = resourceTemplate.template();
        Assert.assertEquals("/{id}", template);
    }

    @Test
    public void testGivingAResourceAndAVariable() {
        ResourceTemplate resourceTemplate = new ResourceTemplate("users", "id");
        String template = resourceTemplate.template();
        Assert.assertEquals("/users/{id}", template);
    }

}

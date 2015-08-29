package com.trit.security.utils.ws;

import org.junit.Assert;
import org.junit.Test;

public class WsResourceBuilderTest {

    @Test
    public void testOnlyOneResourceWithoutId() throws Exception {
        String uri = WsResourceBuilder.resource().add("users").build();
        Assert.assertEquals("/users", uri);
    }

    @Test
    public void testTwoResourcesWithoutId() throws Exception {
        String uri = WsResourceBuilder.resource().add("api").add("users").build();
        Assert.assertEquals("/api/users", uri);
    }

    @Test
    public void testTwoResourcesWithIdInTheSecondResource() throws Exception {
        String uri = WsResourceBuilder.resource().add("api").add("users", "1").build();
        Assert.assertEquals("/api/users/1", uri);
    }

    @Test
    public void testOneResourceWithId() throws Exception {
        String uri = WsResourceBuilder.resource().add("users", "1").build();
        Assert.assertEquals("/users/1", uri);
    }

    @Test
    public void testTwoResourcesWithOneIdEach() throws Exception {
        String uri = WsResourceBuilder.resource().add("api", "v2").add("users", "1").build();
        Assert.assertEquals("/api/v2/users/1", uri);
    }

}

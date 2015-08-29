package com.trit.security.utils.ws;

import org.junit.Test;

public class WsResourceTest {

    @Test(expected = IllegalArgumentException.class)
    public void testNullResource() {
        new WsResource(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullResourceAndNullId() {
        new WsResource(null, null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGivingAResourceAndNullId() {
        new WsResource("users", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullResourceGivingAndId() {
        new WsResource(null, "1");
    }

}

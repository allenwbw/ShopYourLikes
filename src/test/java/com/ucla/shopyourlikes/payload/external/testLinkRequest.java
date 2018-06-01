package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLinkRequest {

    private LinkRequest linkRequest;

    @Before
    public void setUp() {
        this.linkRequest = new LinkRequest();
    }

    @Test
    public void testLinkRequestObjCreation() {
        this.linkRequest.setUserId(111);

        assertEquals(new Integer(111),this.linkRequest.getUserId());

    }
}

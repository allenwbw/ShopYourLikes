package com.ucla.shopyourlikes.payload.internal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testGenerateLinkResponse {

    private GenerateLinkResponse generateLinkResponse;

    @Before
    public void setUp() {
        this.generateLinkResponse = new GenerateLinkResponse();
    }

    @Test
    public void testGenerateLinkResponseObjCreation() {
        this.generateLinkResponse.setEcpc(1);
        this.generateLinkResponse.setLink("www.warriors.com");

        assertEquals(new Integer(1),this.generateLinkResponse.getEcpc());
        assertEquals("www.warriors.com",this.generateLinkResponse.getLink());

    }
}

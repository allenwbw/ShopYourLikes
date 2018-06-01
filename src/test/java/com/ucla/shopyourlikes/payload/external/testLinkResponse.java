package com.ucla.shopyourlikes.payload.external;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLinkResponse {

    private LinkResponse linkResponse;

    @Before
    public void setUp() {
        this.linkResponse = new LinkResponse();
    }

    @Test
    public void testLinkResponseObjCreation() {
        this.linkResponse.setEarnings(1f);
        this.linkResponse.setEcpc(2);

        assertEquals(new Float(1f),this.linkResponse.getEarnings());
        assertEquals(new Integer(2),this.linkResponse.getEcpc());

    }
}

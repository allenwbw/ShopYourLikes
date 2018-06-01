package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testEcpcResponse {

    private EcpcResponse ecpcResponse;

    @Before
    public void setUp() {
        this.ecpcResponse = new EcpcResponse();
    }

    @Test
    public void testEcpcResponseObjCreation() {
        this.ecpcResponse.setEcpc(1);
        this.ecpcResponse.setUrl("www.go.com");

        assertEquals(new Integer(1),ecpcResponse.getEcpc());
        assertEquals("www.go.com",ecpcResponse.getUrl());
    }
}

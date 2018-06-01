package com.ucla.shopyourlikes.payload.internal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testEcpcResponseItem {

    private EcpcResponseItem ecpcResponseItem;

    @Before
    public void setUp() {
        this.ecpcResponseItem = new EcpcResponseItem();
    }

    @Test
    public void testEcpcResponseItemObjCreation() {
        this.ecpcResponseItem.setEcpc(1);
        this.ecpcResponseItem.setOriginalUrl("www.google.com");

        assertEquals(new Integer(1),this.ecpcResponseItem.getEcpc());
        assertEquals("www.google.com",this.ecpcResponseItem.getOriginalUrl());
    }
}

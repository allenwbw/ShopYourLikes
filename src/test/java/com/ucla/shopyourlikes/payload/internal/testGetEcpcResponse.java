package com.ucla.shopyourlikes.payload.internal;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testGetEcpcResponse {

    private GetEcpcResponse getEcpcResponse;

    @Before
    public void setUp() {
        this.getEcpcResponse = new GetEcpcResponse();
    }

    @Test
    public void testGetEcpcResponseObjCreation() {
        List<EcpcResponseItem> ecpcResponseItems = new ArrayList<>();
        EcpcResponseItem ecpcResponseItem = new EcpcResponseItem();
        ecpcResponseItem.setOriginalUrl("www.google.com");
        ecpcResponseItems.add(ecpcResponseItem);
        this.getEcpcResponse.setEcpcList(ecpcResponseItems);

        assertEquals("www.google.com",this.getEcpcResponse.getEcpcList().get(0).getOriginalUrl());

    }
}

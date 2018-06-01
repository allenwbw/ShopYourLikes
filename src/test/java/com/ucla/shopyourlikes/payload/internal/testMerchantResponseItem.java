package com.ucla.shopyourlikes.payload.internal;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMerchantResponseItem {

    private MerchantResponseItem merchantResponseItem;

    @Before
    public void setUp() {
        this.merchantResponseItem = new MerchantResponseItem();
    }

    @Test
    public void testMerchantResponseItemObjCreation() {
        this.merchantResponseItem.setMerchantId(1);
        this.merchantResponseItem.setMerchantName("JR");
        this.merchantResponseItem.setMerchantUrl("www.google.com");

        assertEquals(new Integer(1),this.merchantResponseItem.getMerchantId());
        assertEquals("JR",this.merchantResponseItem.getMerchantName());
        assertEquals("www.google.com",this.merchantResponseItem.getMerchantUrl());
    }
}

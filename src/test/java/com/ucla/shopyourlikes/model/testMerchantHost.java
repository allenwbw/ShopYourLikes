package com.ucla.shopyourlikes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMerchantHost {

    private  MerchantHost merchantHost;

    @Before
    public void setUp() {
        this.merchantHost = new MerchantHost();
    }

    @Test
    public void testMerchantHostObjCreation() {
        merchantHost.setMerchantDomain("www.ucla.edu");
        merchantHost.setMerchantTld("100");

        assertEquals("www.ucla.edu",merchantHost.getMerchantDomain());
        assertEquals("100", merchantHost.getMerchantTld());
    }
}

package com.ucla.shopyourlikes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testMerchant {

    private Merchant merchant;

    @Before
    public void setUp() {
        this.merchant = new Merchant();
    }

    @Test
    public void testMerchantObjCreation() {
        merchant.setMerchantId(111);
        merchant.setMerchantName("shopyourlikes");
        MerchantHost merchantHost = new MerchantHost();
        merchantHost.setMerchantTld("cs130");
        merchantHost.setMerchantDomain("www.ucla.edu");
        merchant.setMerchantHost(merchantHost);

        assertEquals(new Integer(111),merchant.getMerchantId());
        assertEquals("shopyourlikes", merchant.getMerchantName());
        assertEquals("cs130", merchant.getMerchantHost().getMerchantTld());
        assertEquals("www.ucla.edu", merchant.getMerchantHost().getMerchantDomain());

    }
}

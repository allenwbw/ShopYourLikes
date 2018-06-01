package com.ucla.shopyourlikes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLink {
    private Link link;

    @Before
    public void setUp () {
        this.link = new Link();
    }
    @Test
    public void testLinkObjCreation() {

        link.setMerchantName("ucla");
        Merchant merchant = new Merchant();
        MerchantHost merchantHost = new MerchantHost();
        merchantHost.setMerchantTld("cs130");
        merchantHost.setMerchantDomain("www.ucla.edu");
        merchant.setMerchantHost(merchantHost);
        merchant.setMerchantName("cs111");
        merchant.setMerchantId(1000);
        link.setMerchant(merchant);
        link.setIgImageUrl("www.macys.com");
        link.setUserId(123);
        link.setHash("aka");
        link.setUrl("http://go.shopyourlikes.com/pi/e8eeb2331f462b9d?afId=628626&afCampaignId=group1&afCreativeId=2993");
        link.setCreationDate("11:00am");
        link.setOriginalUrl("www.targets.com");
        link.setEarnings(1f);
        link.setEcpc(5);
        link.setName("shop");
        LinkId linkId = new LinkId();
        linkId.setHash("aka");
        link.setLinkId(linkId);
        link.setRedirects(400);

        assertEquals("ucla",link.getMerchantName());
        assertEquals("cs130",link.getMerchant().getMerchantHost().getMerchantTld());
        assertEquals("www.ucla.edu", link.getMerchant().getMerchantHost().getMerchantDomain());
        assertEquals("cs111",link.getMerchant().getMerchantName());
        assertEquals(new Integer(1000), link.getMerchant().getMerchantId());
        assertEquals("www.macys.com", link.getIgImageUrl());
        assertEquals("aka",link.getHash());
        assertEquals("http://go.shopyourlikes.com/pi/aka?afId=null",link.getUrl());
        assertEquals("11:00am",link.getCreationDate());
        assertEquals("www.targets.com",link.getOriginalUrl());
        assertEquals(new Float(1f),link.getEarnings());
        assertEquals(new Integer(5),link.getEcpc());
        assertEquals("shop",link.getName());
        assertEquals("aka",linkId.getHash());
        assertEquals(new Integer(400),link.getRedirects());


    }
}

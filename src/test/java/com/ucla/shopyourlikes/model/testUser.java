package com.ucla.shopyourlikes.model;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testUser {

    private User user;

    @Before
    public void setUp() {
        this.user = new User();
    }

    @Test
    public void testUserObjCreation() {
        user.setApiKey("cs130");
        user.setUserId(100);
        List<Link>linkList =  new ArrayList<>();
        Link link =  new Link();
        link.setMerchantName("ucla");
        linkList.add(link);
        user.setLinks(linkList);
        user.setInstagramId("cs131");
        user.setInstagramName("usc");

        assertEquals("cs130", user.getApiKey());
        assertEquals(new Integer(100), user.getUserId());
        assertEquals(1,user.getLinks().size());
        assertEquals("ucla",user.getLinks().get(0).getMerchantName());
        assertEquals("cs131",user.getInstagramId());
        assertEquals("usc",user.getInstagramName());

    }
}

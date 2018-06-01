package com.ucla.shopyourlikes.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLinkld {

    private LinkId linkId;

    @Before
    public void setUp () {
        this.linkId = new LinkId();
    }

    @Test
    public void testLinkIdObjCreation() {
        linkId.setHash("aka");
        linkId.setUserId(100);

        assertEquals("aka", linkId.getHash());
        assertEquals(new Integer(100),linkId.getUserId());


    }
}

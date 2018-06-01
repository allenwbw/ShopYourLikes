package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testUserSummaryObjCreation {

    private UserSummary userSummary;

    @Before
    public void setUp() {
        this.userSummary = new UserSummary("hello");
    }

    @Test
    public void testUserSummaryObjCreation() {
        assertEquals("hello",this.userSummary.getUserId());
    }
}

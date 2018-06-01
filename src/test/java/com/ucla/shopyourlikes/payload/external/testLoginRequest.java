package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testLoginRequest {

    private  LoginRequest loginRequest;

    @Before
    public void setUp() {
        this.loginRequest= new LoginRequest();
    }

    @Test
    public void testLoginRequestObjCreation() {
        this.loginRequest.setUserId("111");
        this.loginRequest.setApiKey("gowarriors");

        assertEquals("111",this.loginRequest.getUserId());
        assertEquals("gowarriors",this.loginRequest.getApiKey());

    }
}

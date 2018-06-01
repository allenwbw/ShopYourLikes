package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testJwtAuthenticationResponse {

    private JwtAuthenticationResponse jwtAuthenticationResponse;

    @Before
    public void setUp() {
        this.jwtAuthenticationResponse = new JwtAuthenticationResponse("h");
    }

    @Test
    public void testJwtAuthenticationResponseObjCreation() {
        assertEquals("h",jwtAuthenticationResponse.getAccessToken());
        assertEquals("Bearer", jwtAuthenticationResponse.getTokenType());
    }
}

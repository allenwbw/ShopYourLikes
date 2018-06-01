package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class testApiResponse {
    private ApiResponse apiResponse;

    @Before
    public void setUp() {
        this.apiResponse = new ApiResponse(true,"Go Warriors");
    }

    @Test
    public void testApiResponseObjCreation() {
        assertEquals(true,apiResponse.getSuccess());
        assertEquals("Go Warriors", apiResponse.getMessage());
    }
}

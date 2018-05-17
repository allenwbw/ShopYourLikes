package com.ucla.shopyourlikes.service;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;


// TODO: will add more testcase
public class testMerchantService {

    @Mock
    private MerchantService merchantService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation() {
        assertNotNull(merchantService);
    }
}

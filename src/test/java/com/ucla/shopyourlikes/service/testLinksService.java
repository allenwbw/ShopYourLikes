package com.ucla.shopyourlikes.service;

import jdk.internal.dynalink.linker.LinkerServices;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertNotNull;


// TODO: will add more testcase
public class testLinksService {

    @Mock
    private LinksService linksService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testMockCreation() {
        assertNotNull(linksService);
    }

}

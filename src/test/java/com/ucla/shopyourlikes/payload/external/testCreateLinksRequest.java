package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testCreateLinksRequest {

    private CreateLinksRequest createLinksRequest;

    @Before
    public void setUp() {
        this.createLinksRequest = new CreateLinksRequest();
    }

    @Test
    public void testCreateLinksRequestObjCreation() {

        List<String> list = new ArrayList<>();
        list.add("www.baidu.com");
        list.add("www.google.com");
        list.add("www.gowarriors.com");
        createLinksRequest.setUrls(list);

        assertEquals("www.baidu.com",createLinksRequest.getUrls().get(0));
        assertEquals("www.google.com",createLinksRequest.getUrls().get(1));
        assertEquals("www.gowarriors.com",createLinksRequest.getUrls().get(2));

    }

}

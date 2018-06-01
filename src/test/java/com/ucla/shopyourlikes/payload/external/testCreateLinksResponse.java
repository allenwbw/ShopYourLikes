package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testCreateLinksResponse {

    private CreateLinksResponse createLinksResponse;

    @Before
    public void setUp() {
        this.createLinksResponse= new CreateLinksResponse();
    }

    @Test
    public void testCreateLinksResponseObjCreation() {
        List<LinkResponse> list = new ArrayList<>();
        LinkResponse linkResponse = new LinkResponse();
        linkResponse.setCreationDate("12:00am");
        linkResponse.setEarnings(10f);
        list.add(linkResponse);
        this.createLinksResponse.setGeneratedLinks(list);

        assertEquals("12:00am",createLinksResponse.getGeneratedLinks().get(0).getCreationDate());
        assertEquals(new Float(10f),createLinksResponse.getGeneratedLinks().get(0).getEarnings());
        assertEquals(1, createLinksResponse.getGeneratedLinks().size());
    }
}

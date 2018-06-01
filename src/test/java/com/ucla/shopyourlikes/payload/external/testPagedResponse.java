package com.ucla.shopyourlikes.payload.external;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class testPagedResponse {

    private PagedResponse<String> pagedResponse;

    @Before
    public void setUp() {
        this.pagedResponse = new PagedResponse<>();
    }

    @Test
    public void testPagedResponseObjCreation() {
        List<String> list = new ArrayList<>();
        list.add("www.ucla.edu");

        this.pagedResponse.setContent(list);
        this.pagedResponse.setLast(true);

        assertEquals("www.ucla.edu", this.pagedResponse.getContent().get(0));
        assertEquals(true,this.pagedResponse.isLast());

    }

}

package com.ucla.shopyourlikes.controller;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.external.*;
import com.ucla.shopyourlikes.service.LinksService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// TODO: will add more testcase
public class testLinksController {

    @Mock
    private LinksService linksService;

    private LinksController linksController;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
       linksController = new LinksController();
       linksController.linksService =  linksService;
    }

    @Test
    public void testMockCreation() {
        assertNotNull(linksController);
    }

    @Test
    public void testGetLinks() {
        PagedResponse<LinkResponse> pagedResponse = linksController.linksService.getAllLinks(any(),anyInt(),anyInt());
        assertEquals(pagedResponse, linksController.getLinks(any(),anyInt(),anyInt()));
    }

    @Test
    public void testGetEcpc() {
        EcpcResponse ecpcResponse = linksController.linksService.getEcpc(any(),anyString());
        assertEquals(ecpcResponse,linksController.getEcpc(any(),anyString()));
    }

    @Test
    public void testGenerateLinks_ok() {
      when(linksController.linksService.createLinks(any(),anyList())).thenReturn(any());
    }

    @Test
    public void testGenerateLinks_BAD_REQUEST() {
        User user = new User();
        user.setInstagramName("cs130");
        user.setInstagramId("ucla");
        user.setLinks(anyList());
        user.setUserId(1000);
        user.setApiKey("bruin");
        CreateLinksRequest createLinksRequest = new CreateLinksRequest();
        createLinksRequest.setUrls(anyList());
        ResponseEntity<?> responseEntity = linksController.generateLinks(user,createLinksRequest);
        assertEquals(HttpStatus.BAD_REQUEST, responseEntity.getStatusCode());
    }
}

package com.ucla.shopyourlikes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.User;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;


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

    @Test
    public void testGetAllLinks_goodcase () {
        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");
        linksService.getAllLinks(user,-1,1);
    }

    @Test
    public void testGetAllLinksThrowBadRequestException() {
        User user = new User();
        user.setUserId(628626);
        when(linksService.getAllLinks(user,-1,-1)).thenThrow(new BadRequestException(""));
    }

    @Test
    public void testCreateLinks_goodcase() {

        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");

        List<String> urls =  new ArrayList<>();
        urls.add("www.macys.com");

        linksService.createLinks(user,urls);

    }





}

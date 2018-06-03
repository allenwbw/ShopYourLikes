package com.ucla.shopyourlikes.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;


import com.ucla.shopyourlikes.exception.BadRequestException;
import com.ucla.shopyourlikes.model.User;
import com.ucla.shopyourlikes.payload.external.LinkResponse;
import com.ucla.shopyourlikes.payload.external.PagedResponse;
import com.ucla.shopyourlikes.repository.LinkRepository;
import com.ucla.shopyourlikes.repository.MerchantRepository;
import com.ucla.shopyourlikes.repository.UserRepository;
import com.ucla.shopyourlikes.util.AppConstants;
import org.assertj.core.api.Assertions;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
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
    private LinkRepository linkRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private MerchantRepository merchantRepository;

    @Mock
    private ConnexityService connexityService;

    @InjectMocks
    private LinksService linksService;

    @Before
    public void setupMock() {
        MockitoAnnotations.initMocks(this);
        linksService = new LinksService();
        linkRepository = linksService.linkRepository;
        userRepository = linksService.userRepository;
        merchantRepository = linksService.merchantRepository;
        connexityService = linksService.connexityService;
    }

    @Test (expected = BadRequestException.class)
    public void testGetAllLinks_invalidPage_ThrowBadRequestException() {
        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");
        linksService.getAllLinks(user,-1,1);
    }

    @Test (expected = BadRequestException.class)
    public void testGetAllLinks_invalidSize_ThrowBadRequestException() {
        User user = new User();
        user.setUserId(628626);
        user.setApiKey("7438a399d83eceffef422e5563a94401");
        linksService.getAllLinks(user,1, AppConstants.MAX_PAGE_SIZE+1);
    }

}
